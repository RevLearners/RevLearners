import io.revlearners.model.bean.InboxItem;
import io.revlearners.util.configs.AppConfig;
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
            InboxItem item = new InboxItem("this is a test message");
            session.save(item);
            session.getTransaction().commit();
        }
    }
}

