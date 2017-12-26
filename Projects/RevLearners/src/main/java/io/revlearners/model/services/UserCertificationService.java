package io.revlearners.model.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.dao.hibernate.BeanDao;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;

public class UserCertificationService {
	
	@Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;
    
    public void addUserCertification(UserCertification userCert) {

		Transaction tx = null;
		try (Session session = sf.openSession()) {
			tx = session.beginTransaction();
			BeanDao dao = new BeanDao();
			dao.create(userCert);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}

	}
    
    public void updateUserCertification(UserCertification userCert) {

		Transaction tx = null;
		try (Session session = sf.openSession()) {
			tx = session.beginTransaction();
			BeanDao dao = new BeanDao();
			dao.update(UserCertification.class, userCert);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}

	}
    
    
    
    

}
