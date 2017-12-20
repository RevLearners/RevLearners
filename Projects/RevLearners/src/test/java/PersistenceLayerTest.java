import static org.junit.Assert.*;

import io.revlearners.util.commons.configs.Constants;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import io.revlearners.model.bean.*;
import io.revlearners.model.services.dao.interfaces.contracts.ITopicService;
import io.revlearners.util.commons.configs.PersistenceConfig;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PersistenceConfig.class}, loader = AnnotationConfigContextLoader.class)
public class PersistenceLayerTest {

    @Autowired
    private SessionFactory sf;

    @Autowired
    private ITopicService topicService;

    private Session session;

    @Before
    public final void before() {
        session = sf.openSession();
    }

    @After
    public final void after() {
        session.close();
    }

    @Test
    public void userInsertTest() {

        UserStatus status = new UserStatus("Pending");
        User user = new User(
                "John",
                null,
                "Doe",
                session.load(UserStatus.class, Constants.STATUS_PENDING),
                session.load(UserRole.class, Constants.ROLE_BASIC)
        );
        Credentials credentials = new Credentials(user, "mail@email.com", "aUsername", "password", "this is a salt, a really bad salt, but a salt none the less");
        session.beginTransaction();
        session.save(credentials);
        session.getTransaction().commit();
    }

    @Test
    public void questionInsertTest() {
        session.beginTransaction();
        Question quest = new Question(
                session.load(Topic.class, Constants.TOPIC_CORE_JAVA),
                session.load(QuestionType.class, Constants.QUESTION_TRUE_FALSE),
                session.load(QuestionDifficulty.class, Constants.DIFFICULTY_EASY),
                "Is the answer to life 42?"
        );
        session.save(quest);
        session.save(new QuestionOption(
                quest,
                "True",
                true
        ));
        session.save(new QuestionOption(
                quest,
                "False",
               false
        ));
        session.getTransaction().commit();
    }
}
