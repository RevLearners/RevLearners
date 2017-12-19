
import io.revlearners.model.bean.*;
import io.revlearners.model.services.dao.hibernate.injectors.TopicService;
import io.revlearners.util.commons.configs.PersistenceConfig;
import io.revlearners.util.persistence.AbstractService;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestDriver {
    private static ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    private static SessionFactory sf;

    static {
        sf = springContext.getBean(SessionFactory.class);
    }

    private AbstractService<Topic> topicService;

    public static void main(String[] args) {

        try (Session session = sf.openSession()) {
            session.beginTransaction();


            Long regularRoleId = (Long) session.save(new UserRole(1L,"Regular"));
            Long pendingStatusId = (Long) session.save(new UserStatus(1L,"Pending"));


            UserStatus status = new UserStatus("Pending");
            User user = new User(
                    "John",
                    null,
                    "Doe",
                    new UserStatus(pendingStatusId, "Pending"),
                    new UserRole(regularRoleId, "Regular")
            );
            Credentials credentials = new Credentials(user, "mail@email.com","password", "this is a salt, a really bad salt, but a salt none the less");
            session.save(credentials);

            session.getTransaction().commit();
        } finally {
        }

    }
}
