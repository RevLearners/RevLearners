package testNGUnitTests;

import config.MockPersistenceConfig;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import io.revlearners.model.bean.AbstractBean;
import io.revlearners.model.services.dao.interfaces.contracts.IMessageService;
import io.revlearners.model.services.dao.interfaces.contracts.IQuestionService;
import io.revlearners.model.services.dao.interfaces.contracts.IRankService;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.model.services.dao.interfaces.contracts.IUserService;

@ContextConfiguration(classes = { MockPersistenceConfig.class }, loader = AnnotationConfigContextLoader.class)
public abstract class TestNGSpringTests  extends AbstractTestNGSpringContextTests {

	@Autowired
	protected SessionFactory sf;

	@Autowired
	protected IBeanService service;

	@Autowired
	protected IUserService userService;

	@Autowired
	protected IQuestionService questionService;

	@Autowired
	protected IMessageService messageService;

	@Autowired
	protected IRankService rankService;

}
