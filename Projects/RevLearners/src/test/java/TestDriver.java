
import io.revlearners.model.bean.Topic;
import io.revlearners.util.commons.configs.AppConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDriver {
    public static void main(String[] args) {
        ApplicationContext springContext = new AnnotationConfigApplicationContext(AppConfig.class);
        SessionFactory sessionFactory = springContext.getBean(SessionFactory.class);

        try (Session session = sessionFactory.openSession()){
            session.beginTransaction();
            Topic item = new Topic();
            item.setTopicName("whatever");
            
            session.save(item);
            session.getTransaction().commit();
        }
    }
}

