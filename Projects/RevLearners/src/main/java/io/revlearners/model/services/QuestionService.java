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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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
     * @param
     * @return
     */
	public QuizAttempt scoreQuiz(Quiz quiz, User user, List<Question> questions, Map<Long, List<QuestionOption>> selectedAnswers)  {
	    Transaction tx = null;
	    QuizAttempt attempt = null;

	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();
            float score = scoreAll(questions, selectedAnswers, session);
            List<QuestionOption> flattened = flattenOptions(selectedAnswers);
            attempt = new QuizAttempt(score, user, quiz, flattened);
            session.save(attempt);
            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }
        return attempt;
	}

	private List<QuestionOption> flattenOptions(Map<Long, List<QuestionOption>> options) {
        List<QuestionOption> flattenedOptions = new ArrayList<>();
        for (List<QuestionOption> o: options.values())
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
    private float scoreAll(List <Question> questions, Map<Long, List<QuestionOption>> selected, Session session) {
        float score = 0;
	    for (Question q: questions) {
            List<QuestionOption> selectedForQ = selected.get(q.getId());
            Question referenceQ = beanService.fetchSubTypeById(Question.class, q.getId(), session);
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
    private float scoreOne(Question question, List<QuestionOption> selectedOptions, Question reference) {
            QuestionOption selected = selectedOptions.get(0);
            boolean answeredCorrectly = reference.getOptions().stream()
                    .anyMatch(option -> option.isCorrect() && option.getId().equals(selected.getId()));

            if (answeredCorrectly) {
                return question.getDifficulty().getMultiplier() * question.getType().getBaseVal();
            }
            return 0;
    }


    /**
     * generates a random list of questions in the specified topic;
     * options are shuffled for each question
     *
     * @param n
     * @param topic
     * @return
     */
    public List<Question> generateQuestions(int n, Topic topic) {
	    Transaction tx = null;
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();
            List<Question> questions = questionDao.fetchRandomQuestionsByTopic(n, topic, session);

            for (Question q: questions)
                Collections.shuffle(q.getOptions());

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
    public void addQuestion(Question question, List<QuestionOption> options) {
 	    Transaction tx = null;
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();

            beanService.create(question, session);
            for (QuestionOption option: options) {
                option.setQuestion(question);
                beanService.create(option, session);
            }

            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }
    }

}
