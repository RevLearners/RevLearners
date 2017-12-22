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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionService {
    @Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;


    /**
     * each question will contain
     * @param questions
     * @return
     */
	public Long SubmitQuestion(List<Question> questions) {
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
