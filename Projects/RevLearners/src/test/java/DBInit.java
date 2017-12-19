import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import io.revlearners.model.bean.Certification;
import io.revlearners.model.bean.Credentials;
import io.revlearners.model.bean.QuestionDifficulty;
import io.revlearners.model.bean.QuestionType;
import io.revlearners.model.bean.ReasonType;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.PersistenceConfig;
import io.revlearners.util.persistence.AbstractService;

public class DBInit {

    private static ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    private static SessionFactory sf;

    static {
        sf = springContext.getBean(SessionFactory.class);
    }

    private AbstractService<Topic> topicService;

    public static void main(String[] args) {

    		Collection<Map<Integer, String>> maps = new LinkedList<Map<Integer,String>>();
    		Map<Integer, String> map = new LinkedHashMap<Integer, String>();
    		maps.add(Constants.getQuestionDifficulties());
    		maps.add(Constants.getQuestiontypes());
    		maps.add(Constants.getTopics());
    		maps.add(Constants.getUserRoles());
    		maps.add(Constants.getUserStatuses());

        try (Session session = sf.openSession()) {
            session.beginTransaction();
            
            session.save(credentials);

            session.getTransaction().commit();
        } finally {
        	((AnnotationConfigApplicationContext) springContext).close();
        }

    }
}
