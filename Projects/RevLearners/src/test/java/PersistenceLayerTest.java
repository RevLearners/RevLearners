import static org.junit.Assert.*;

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
	public void topicInsertTest() {
		topicService.create(new Topic("Topic 1"));
	}
}
