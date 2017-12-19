import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
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

    private static ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    private static SessionFactory sf;

    static {
        sf = springContext.getBean(SessionFactory.class);
    }

    private AbstractService<Topic> topicService;

    public static void main(String[] args) {

        try (Session session = sf.openSession()) {
            session.beginTransaction();
            Map<Integer, String> map;
            String[] arr, arr2;
            int i, j;
            
            map = Constants.getUserRoles();
            for(Integer key : map.keySet()) {
            		session.save(new UserRole(Long.valueOf(key.longValue()), map.get(key)));
            }
            
            map = Constants.getUserStatuses();
            for(Integer key : map.keySet()) {
            		session.save(new UserStatus(Long.valueOf(key.longValue()), map.get(key)));
            }
            
            map = Constants.getMessageStatuses();
            for(Integer key : map.keySet()) {
            		session.save(new MessageStatus(Long.valueOf(key.longValue()), map.get(key)));
            }
            
            map = Constants.getMimeTypes();
            for(Integer key : map.keySet()) {
            		session.save(new MimeType(Long.valueOf(key.longValue()), map.get(key)));
            }
            
            map = Constants.getReasonTypes();
            for(Integer key : map.keySet()) {
            		session.save(new ReasonType(Long.valueOf(key.longValue()), map.get(key)));
            }
            
            map = Constants.getJRanks();
            for(Integer key : map.keySet()) {
            		session.save(new UserTopicRank());
            }
            
            
//            session.save();

            session.getTransaction().commit();
        } finally {
        	((AnnotationConfigApplicationContext) springContext).close();
        }

    }
}
