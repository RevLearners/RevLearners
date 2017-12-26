package io.revlearners.model.services;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.revlearners.model.bean.User;
import io.revlearners.model.dao.hibernate.BeanDao;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.PersistenceConfig;

public class UserService {
	ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
	SessionFactory sf;
	{
		sf = springContext.getBean(SessionFactory.class);
	}

	/**
	 * A method used to create a User's account and add it to the database.
	 * 
	 * @param userCred
	 *            -Information about the User. Subject to change based on how this
	 *            method is called.
	 */
	public void CreateAccount(User newUser) {
		/*
		 * This section is to create a temporary user so we can inserted into the
		 * database. The implementation is open to change based on the parameter.
		 */

		Transaction tx = null;
		try (Session session = sf.openSession()) {
			tx = session.beginTransaction();
			BeanDao dao = new BeanDao();
			dao.create(newUser);

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}

	}

	/**
	 * A method used to check if username is currently in the database.
	 * 
	 * @param userInput
	 *            - User's input for username confirmation.
	 * @return - Returns true if username exist in the database, false otherwise.
	 */
	public Boolean userExist(String userInput) {

		Transaction tx = null;
		try (Session session = sf.openSession()) {
			tx = session.beginTransaction();
			BeanDao dao = new BeanDao();
			List<User> allUsers = dao.fetchAllSubTypes(User.class);
			for (User u : allUsers) {
				if (u.getUsername() == userInput) {
					return false;
				}
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}

		return true;
	}

	/**
	 * A method used to get an user's account info based on the username.
	 * 
	 * @param userInput
	 *            - User's input to search for an account.
	 * @return - Return user's account info, null if account not found.
	 */
	public User getUserByUsername(String userInput) {

		Transaction tx = null;
		User currUser = null;
		try (Session session = sf.openSession()) {
			tx = session.beginTransaction();
			BeanDao dao = new BeanDao();
			List<User> allUsers = dao.fetchAllSubTypes(User.class);
			for (User u : allUsers) {
				if (u.getUsername() == userInput) {
					currUser = u;
					break;
				}
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}

		return currUser;
	}

	/**
	 * A method for getting a user's account info based on the email entered.
	 * 
	 * @param userInput
	 *            - Input for an email used to search for account.
	 * @return - Return user's account info, null if not found.
	 */
	public User getuserByEmail(String userInput) {

		Transaction tx = null;
		User currUser = null;
		try (Session session = sf.openSession()) {
			tx = session.beginTransaction();
			BeanDao dao = new BeanDao();
			List<User> allUsers = dao.fetchAllSubTypes(User.class);
			for (User u : allUsers) {
				if (u.getEmail() == userInput) {
					currUser = u;
					break;
				}
			}

			session.getTransaction().commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
		}

		return currUser;
	}

}
