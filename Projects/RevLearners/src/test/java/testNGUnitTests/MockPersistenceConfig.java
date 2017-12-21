package testNGUnitTests;


import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import io.revlearners.model.bean.*;
import io.revlearners.model.dao.hibernate.*;
import io.revlearners.model.dao.interfaces.*;
import io.revlearners.model.services.dao.hibernate.injectors.*;
import io.revlearners.model.services.dao.interfaces.contracts.*;

@Configuration
@EnableAsync
@EnableTransactionManagement
@ComponentScan("io.revlearners.model")
public class MockPersistenceConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(System.getenv("RDS_DRIVER_CLASS"));
		ds.setUrl(System.getenv("RDS_URL"));
		ds.setUsername(System.getenv("RDS_USERNAME"));
		ds.setPassword(System.getenv("RDS_PASSWORD"));
		return ds;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory()  {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource());
		factoryBean.setPackagesToScan("io.revlearner.model"); // varargs method

		Properties props = new Properties();
		props.setProperty("hibernate.hbm2ddl.auto", "create");
		props.setProperty("hibernate.show_sql", "true");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		props.setProperty("hibernate.connection.isolation", String.valueOf(Connection.TRANSACTION_READ_COMMITTED));

		// user hibernate default connection pool; not for production
		props.setProperty("hibernate.connection.pool_size", "10");

		factoryBean.setHibernateProperties(props);
		factoryBean.setAnnotatedClasses( // register @Entity classes
				Certification.class, FileBlob.class, Message.class, MessageStatus.class,
				MimeType.class, Notification.class, Question.class, QuestionDifficulty.class, QuestionOption.class,
				QuestionType.class, Quiz.class, Rank.class, Topic.class, User.class,
				UserCertification.class, UserTopicRank.class, UserRole.class, UserStatus.class, Reason.class,
				ReportQuestion.class, ReasonType.class);
		return factoryBean;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * BeanPostProcessor bean
	 *
	 * @return
	 */
	@Bean
	public BeanPostProcessor persistenceTranslation() {
		// to translate hibernate exceptions to spring exceptions (for whatever reason)
		return new PersistenceExceptionTranslationPostProcessor();
	}

	/**
	 * Hibernate Transaction Manager
	 * 
	 * @return
	 */
	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		final HibernateTransactionManager tm = new HibernateTransactionManager();
		tm.setSessionFactory(sessionFactory().getObject());
		return tm;
	}

	@Bean
	public IMessageDao messageHibernateDao() {
		return new MessageDao();
	}

	@Bean
	public IQuestionDao questionHibernateDao() {
		return new QuestionDao();
	}

	@Bean
	public IRankDao rankHibernateDao() {
		return new RankDao();
	}

	@Bean
	public ITopicDao topicHibernateDao() {
		return new TopicDao();
	}

	@Bean
	public IUserDao userHibernateDao() {
		return new UserDao();
	}

	@Bean
	public ITopicService topicHibernateService() {
		return new TopicService();
	}

	@Bean
	public IMessageService messageHibernateService() {
		return new MessageService();
	}

	@Bean
	public IQuestionService questionHibernateService() {
		return new QuestionService();
	}

	@Bean
	public IRankService rankHibernateService() {
		return new RankService();
	}

	@Bean
	public IUserService userHibernateService() {
		return new UserService();
	}
}
