
import io.revlearners.model.bean.Topic;
import io.revlearners.model.services.dao.hibernate.injectors.TopicService;
import io.revlearners.util.commons.configs.PersistenceConfig;
import io.revlearners.util.persistence.AbstractService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDriver {

	@Autowired
	private static SessionFactory sf;

	@Autowired
	private static AbstractService<Topic> topicService;

	private static Session session;

	public static void main(String[] args) {
		ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);

		session = sf.openSession();

		try {

			// topicService = springContext.getBean(TopicService.class);
			// Topic topic = new Topic();
			// topic.setTopicName("Topic1");
			// topicService.save(topic);

		} finally {
			((AnnotationConfigApplicationContext) springContext).close();
		}
		//
		// try (Session session = sessionFactory.openSession()){
		// session.beginTransaction();
		// Topic item = new Topic();
		// item.setTopicName("whatever");
		//
		// session.save(item);
		// session.getTransaction().commit();
		// }
	}
}
