package testNGUnitTests.dao;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import io.revlearners.util.commons.configs.Constants;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import testNGUnitTests.TestNGSpringTests;

import java.util.List;

public class QuestionDaoTest extends TestNGSpringTests {

    @Autowired
    IQuestionDao questionDao;


    // todo add dummy questions
	@Test
	public void questionInsertTest() {

		try(Session session = sf.openSession()) {
            session.beginTransaction();

            List<Question> questions = questionDao.fetchRandomQuestionsByTopic(
                    5,
                    session.load(Topic.class, Constants.TOPIC_CORE_JAVA),
                    session
            );

            System.out.println(questions);

            session.getTransaction().commit();
        }
	}
}
