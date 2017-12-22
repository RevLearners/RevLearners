package io.revlearners.model.services;

import io.revlearners.model.bean.*;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionService {
    @Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;


    /**
     * Each question will contain a Set<QuestionOption> which will
     * contain exactly one option denoting the option selected by
     * the user
     *
     * should match the one in the database except for the fact that
     * the its optoin
     *
     * @param quiz
     * @return
     */
	public double scoreQuiz(Quiz quiz) {
	    Transaction tx = null;

	    try(Session session = sf.openSession()) {
            double score = scoreQuestions(quiz.getQuestions(), session);
            tx = session.beginTransaction();


            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }

        return -1;
	}

    /**
     * calculates the score given a set answered questions
     * assumes only one question is correct per question
     *
     * @param questions
     * @return
     */
    private double scoreQuestions(Set<Question> questions, Session session) {
        double score = 0;
	    for (Question q: questions) {
            QuestionOption selected = (QuestionOption)(q.getOptions().toArray()[0]);
            Question poolQuestion = beanService.fetchSubTypeById(Question.class, q.getId(), session);

            boolean answeredCorrectly = poolQuestion.getOptions().stream()
                    .anyMatch(option -> option.isCorrect() && option.getId().equals(selected.getId()));

            if (answeredCorrectly) {
                score += q.getDifficulty().getMultiplier() * q.getType().getBaseVal();
            }
        }
        return score;
    }

    public List<Question> generateQuestions(Long n, Topic category) {
	    Transaction tx = null;
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();




            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }

        return null;
    }

}
