package io.revlearners.model.services;

import io.revlearners.model.bean.*;
import io.revlearners.model.dao.hibernate.QuestionDao;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.*;

public class QuestionService {
    @Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;

    @Autowired
    QuestionDao questionDao;

    /**
     * answers map maps question id to the list of selected answers for said id
     *
     * @param user
     * @param challenge
     * @param selectedAnswers
     * @return
     */
	public ChallengeAttempt scoreQuiz(User user, Challenge challenge, Map<Long, Set<QuestionOption>> selectedAnswers)  {
	    Transaction tx = null;
	    ChallengeAttempt attempt = null;

	    try(Session session = sf.openSession()) {
	        Set<Question> questions = challenge.getQuiz().getQuestions();
            tx = session.beginTransaction();
            float score = scoreAll(questions, selectedAnswers);
            Set<QuestionOption> flattened = flattenOptions(selectedAnswers);
            attempt = new ChallengeAttempt(challenge, user, flattened, score);
            session.save(attempt);
            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }
        return attempt;
	}

	private Set<QuestionOption> flattenOptions(Map<Long, Set<QuestionOption>> options) {
        Set<QuestionOption> flattenedOptions = new HashSet<>();
        for (Set<QuestionOption> o: options.values())
            flattenedOptions.addAll(o);
        return flattenedOptions;
    }

    /**
     * calculates the score given a set answered questions
     * assumes only one question is correct per question
     *
     * @param questions
     * @return
     */
    private float scoreAll(Set <Question> questions, Map<Long, Set<QuestionOption>> selected) {
        float score = 0;
	    for (Question q: questions) {
            Set<QuestionOption> selectedForQ = selected.get(q.getId());
            Question referenceQ = beanService.fetchSubTypeById(Question.class, q.getId());
            score += scoreOne(q, selectedForQ, referenceQ);

        }
        return score;
    }

    /**
     * assumes each question only has one correct option; can easily extended later
     * @param question
     * @param selectedOptions
     * @param reference
     * @return
     */
    private float scoreOne(Question question, Set<QuestionOption> selectedOptions, Question reference) {
            QuestionOption selected = new ArrayList<>(selectedOptions).get(0);
            boolean answeredCorrectly = reference.getOptions().stream()
                    .anyMatch(option -> option.isCorrect() && option.getId().equals(selected.getId()));

            if (answeredCorrectly) {
                return question.getDifficulty().getMultiplier() * question.getType().getBaseVal();
            }
            return 0;
    }


    /**
     * generates a random list of questions in the specified topic;
     * <d>options are shuffled for each question</d> can't shuffle sets
     *
     * @param n
     * @param topic
     * @return
     */
    public Set<Question> generateQuestions(int n, Topic topic) {
	    Transaction tx = null;
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();
            Set<Question> questions = questionDao.fetchRandomQuestionsByTopic(n, topic);

            session.getTransaction().commit();
            return questions;
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }

        return null;
    }

    /**
     * it is assumed that one of these options is marked correct
     *
     * @param question
     * @param options
     */
    public void addQuestion(Question question, Set<QuestionOption> options) {
 	    Transaction tx = null;
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();

            beanService.create(question);
            for (QuestionOption option: options) {
                option.setQuestion(question);
                beanService.create(option);
            }

            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }
    }

}
