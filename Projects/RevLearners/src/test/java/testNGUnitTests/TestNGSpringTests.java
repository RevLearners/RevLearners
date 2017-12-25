package testNGUnitTests;

import config.MockPersistenceConfig;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;

import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;

@ContextConfiguration(classes = { MockPersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public abstract class TestNGSpringTests  extends AbstractTransactionalTestNGSpringContextTests {

	@Autowired
	protected SessionFactory sf;

	@Autowired
	@Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
	protected IBeanService service;

}
