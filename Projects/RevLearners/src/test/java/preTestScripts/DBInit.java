package preTestScripts;

import java.io.Serializable;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.revlearners.model.bean.*;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.PersistenceConfig;
import io.revlearners.util.persistence.AbstractService;

public class DBInit {

	public static void main(String[] args) {

		ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
		SessionFactory sf;

		sf = springContext.getBean(SessionFactory.class);

		try {
			create(sf);
		} finally {
			((AnnotationConfigApplicationContext) springContext).close();
		}
	}

	public static void create(SessionFactory sf) {

		try (Session session = sf.openSession()) {
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

			saveEntities(Constants.getTopics(), session);
			saveEntities(Constants.getQuestionReasons(), session);
			saveEntities(Constants.getUserReasons(), session);

			saveEntities(Constants.getQuestionTypes(), session);

			saveEntities(Constants.getJavaranks(), session);
//			saveEntities(Constants.getJ2eeranks(), session);
//			saveEntities(Constants.getJtaranks(), session);
//			saveEntities(Constants.getJparanks(), session);
//			saveEntities(Constants.getSpringranks(), session);
//			saveEntities(Constants.getPlsqlranks(), session);
//			saveEntities(Constants.getTsqlranks(), session);
//			saveEntities(Constants.getMysqlranks(), session);
//			saveEntities(Constants.getPostgresqlranks(), session);
//			saveEntities(Constants.getWebranks(), session);
//			saveEntities(Constants.getJqueryranks(), session);
//			saveEntities(Constants.getAngularjsranks(), session);
			saveEntities(Constants.getAngular4ranks(), session);
			saveEntities(Constants.getDevopsranks(), session);
//			saveEntities(Constants.getMicrosranks(), session);
			saveEntities(Constants.getHibernateRanks(), session);
			saveEntities(Constants.getDesignPatternRanks(), session);

			saveEntities(Constants.getCertifications(), session);
			saveEntities(Constants.getQuestionDifficulties(), session);

			session.getTransaction().commit();
		}
	}

	public static void saveEntities(Map<Long, ? extends Serializable> ranks, Session session) {
		for (Long id : ranks.keySet()) {
			session.save(ranks.get(id));
		}
	}
}