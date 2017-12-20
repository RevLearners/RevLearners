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

    private static ApplicationContext springContext = new AnnotationConfigApplicationContext(PersistenceConfig.class);
    private static SessionFactory sf;

    static {
        sf = springContext.getBean(SessionFactory.class);
    }

    private AbstractService<Topic> topicService;

    public static void main(String[] args) {

        try (Session session = sf.openSession()) {
            session.beginTransaction();
<<<<<<< HEAD
            Map<Integer, String> map;
            String[] arr;
            Integer[] arr2;
            int i, j;
            
            map = Constants.getUserRoles();
            for(Integer key : map.keySet()) {
            		session.save(new UserRole(Long.valueOf(key.longValue()), map.get(key)));
=======

            Map<Long, String> map = Constants.getUserRoles();
            for (Long id : map.keySet()) {
                session.save(new UserRole(id, map.get(id)));
>>>>>>> 3f6ae845eb739d30e4cfbe01b5e9107e14c8ab1b
            }

            map = Constants.getUserStatuses();
            for (Long id : map.keySet()) {
                session.save(new UserStatus(id, map.get(id)));
            }

            map = Constants.getMessageStatuses();
            for (Long id : map.keySet()) {
                session.save(new MessageStatus(id, map.get(id)));
            }

            map = Constants.getMimeTypes();
            for (Long id : map.keySet()) {
                session.save(new MimeType(id, map.get(id)));
            }

            map = Constants.getReasonTypes();
<<<<<<< HEAD
            for(Integer key : map.keySet()) {
            		session.save(new ReasonType(Long.valueOf(key.longValue()), map.get(key)));
            }
            
            map = Constants.getJRanks();
//            arr = {}
            for(Integer key : map.keySet()) {
//            		session.save(new );
            }
            
            map = Constants.getAngular4Ranks();
            for(Integer key : map.keySet()) {
//            		session.save()
            }
            

            
            
//            session.save();
=======
            for (Long id : map.keySet())
                session.save(new ReasonType(id, map.get(id)));

            saveEntities(Constants.getQuestionReasons(), session);
            saveEntities(Constants.getUserReasons(), session);

            map = Constants.getTopics();
            for (Long id : map.keySet())
                session.save(new Topic(id, map.get(id)));

            saveEntities(Constants.getQuestionTypes(), session);

            saveEntities(Constants.getJRanks(), session);
            saveEntities(Constants.getAngular4Ranks(), session);
            saveEntities(Constants.getDevOpsRanks(), session);
            saveEntities(Constants.getHibernateRanks(), session);
            saveEntities(Constants.getDesignPatternRanks(), session);

            saveEntities(Constants.getCertifications(), session);
            saveEntities(Constants.getQuestionDifficulties(), session);
>>>>>>> 3f6ae845eb739d30e4cfbe01b5e9107e14c8ab1b

            session.getTransaction().commit();
        } finally {
            ((AnnotationConfigApplicationContext) springContext).close();
        }
    }

    public static void saveEntities(Map<Long, ? extends Serializable> ranks, Session session) {
        for (Long id : ranks.keySet()) {
            session.save(ranks.get(id));
        }
    }
}
