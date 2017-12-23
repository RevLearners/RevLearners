package preTestScripts;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import config.MockPersistenceConfig;
import io.revlearners.model.bean.*;
import io.revlearners.model.services.dao.hibernate.injectors.BeanService;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.PersistenceConfig;
import io.revlearners.util.persistence.AbstractService;

@Transactional(value = Constants.TRANSACTION_HIBERNATE_MANAGER)
public class DBInit {

	public static void main(String[] args) {

		ApplicationContext springContext = new AnnotationConfigApplicationContext(MockPersistenceConfig.class);
		SessionFactory sf;
		Session session;
		sf = springContext.getBean(SessionFactory.class);

		try {
			session = sf.openSession();
			create(session);
			session.close();
		} finally {
			((AnnotationConfigApplicationContext) springContext).close();
		}
	}

	public DBInit() {
//		create();
	}

	public static void create(Session session) {
		
		session.beginTransaction();
		
		Map<Long, String> map = Constants.getUserRoles();
		for (Long id : map.keySet()) {
			session.save(new UserRole(id, map.get(id)));
		}

		map = Constants.getUserStatuses();
		for (Long id : map.keySet()) {
			session.save(new UserStatus(id, map.get(id)));
		}

		map = Constants.getMessageStatuses();
		for (Long id : map.keySet()) {
			session.save(new MessageStatus(id, map.get(id)));
		}

		map = Constants.getRequestStatuses();
		for (Long id : map.keySet()) {
			session.save(new RequestStatus(id, map.get(id)));
		}

		map = Constants.getMimeTypes();
		for (Long id : map.keySet()) {
			session.save(new MimeType(id, map.get(id)));
		}

		map = Constants.getReasonTypes();

		for (Long id : map.keySet())
			session.save(new ReasonType(id, map.get(id)));

		saveEntities(session, Constants.getTopics());
		saveEntities(session, Constants.getQuestionReasons());
		saveEntities(session, Constants.getUserReasons());

		saveEntities(session, Constants.getQuestionTypes());

		saveEntities(session, Constants.getJavaranks());
		// saveEntities(Constants.getJ2eeranks(), session);
		// saveEntities(Constants.getJtaranks(), session);
		// saveEntities(Constants.getJparanks(), session);
		// saveEntities(Constants.getSpringranks(), session);
		// saveEntities(Constants.getPlsqlranks(), session);
		// saveEntities(Constants.getTsqlranks(), session);
		// saveEntities(Constants.getMysqlranks(), session);
		// saveEntities(Constants.getPostgresqlranks(), session);
		// saveEntities(Constants.getWebranks(), session);
		// saveEntities(Constants.getJqueryranks(), session);
		// saveEntities(Constants.getAngularjsranks(), session);
		saveEntities(session, Constants.getAngular4ranks());
		saveEntities(session, Constants.getDevopsranks());
		// saveEntities(Constants.getMicrosranks(), session);
		saveEntities(session, Constants.getHibernateRanks());
		saveEntities(session, Constants.getDesignPatternRanks());

		saveEntities(session, Constants.getCertifications());
		saveEntities(session, Constants.getQuestionDifficulties());

		session.getTransaction().commit();
	}

	public static <T extends Serializable> void saveEntities(Session session, Map<Long, ? extends Serializable> ranks) {
		for (Long id : ranks.keySet()) {
			session.save(ranks.get(id));
		}
	}
}
