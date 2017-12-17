package io.revlearners.util.commons.configs;

import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import io.revlearners.model.bean.*;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
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

import io.revlearners.model.dao.hibernate.MessageHibernateDao;
import io.revlearners.model.dao.hibernate.QuestionHibernateDao;
import io.revlearners.model.dao.hibernate.RankHibernateDao;
import io.revlearners.model.dao.hibernate.TopicHibernateDao;
import io.revlearners.model.dao.hibernate.UserHibernateDao;
import io.revlearners.model.dao.interfaces.IMessageDao;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import io.revlearners.model.dao.interfaces.IRankDao;
import io.revlearners.model.dao.interfaces.ITopicDao;
import io.revlearners.model.dao.interfaces.IUserDao;
import io.revlearners.model.services.dao.hibernate.injectors.MessageHibernateDaoInjectorService;
import io.revlearners.model.services.dao.hibernate.injectors.QuestionHibernateDaoInjectorService;
import io.revlearners.model.services.dao.hibernate.injectors.RankHibernateDaoInjectorService;
import io.revlearners.model.services.dao.hibernate.injectors.TopicHibernateDaoInjectorService;
import io.revlearners.model.services.dao.hibernate.injectors.UserHibernateDaoInjectorService;
import io.revlearners.model.services.dao.interfaces.contracts.IMessageDaoInjectorService;
import io.revlearners.model.services.dao.interfaces.contracts.IQuestionDaoInjectorService;
import io.revlearners.model.services.dao.interfaces.contracts.IRankDaoInjectorService;
import io.revlearners.model.services.dao.interfaces.contracts.ITopicDaoInjectorService;
import io.revlearners.model.services.dao.interfaces.contracts.IUserDaoInjectorService;



@Configuration
@EnableAsync
@EnableTransactionManagement
@ComponentScan("io.revlearners.model")
public class AppConfig {

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
    public LocalSessionFactoryBean sessionFactory(DataSource ds) {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        factoryBean.setDataSource(ds);
        factoryBean.setPackagesToScan("io.revlearner.model"); // varargs method

        Properties props = new Properties();
        props.setProperty("hibernate.hbm2ddl.auto", "create");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
        props.setProperty("hibernate.connection.isolation", String.valueOf(Connection.TRANSACTION_READ_COMMITTED));

        // user hibernate default connection pool; not for production
        props.setProperty("hibernate.connection.pool_size", "10");

        factoryBean.setHibernateProperties(props);
        factoryBean.setAnnotatedClasses(    // register @Entity classes
                Certification.class,
                Credentials.class,
                FileBlob.class,
                Message.class,
                MessageStatus.class,
                MimeType.class,
                Notification.class,
                Question.class,
                QuestionDifficulty.class,
                QuestionOption.class,
                QuestionPoints.class,
                QuestionType.class,
                Quiz.class,
                Rank.class,
                Topic.class,
                User.class,
                UserCertification.class,
                UserLangRank.class,
                UserRole.class,
                UserStatus.class
        );
        return factoryBean;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * SessionFactory bean
     * @param sessionFactory
     * @return
     */
    @Bean
    PlatformTransactionManager txManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
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
    
    @Bean
    @Qualifier(Constants.QUALIFY_MESSAGE_DAO)
    public IMessageDao getIMessageDao() {
    	return new MessageHibernateDao();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_QUESTION_DAO)
    public IQuestionDao getIQuestionDao() {
    	return new QuestionHibernateDao();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_RANK_DAO)
    public IRankDao getIRankDao() {
    	return new RankHibernateDao();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_TOPIC_DAO)
    public ITopicDao getITopicDao() {
    	return new TopicHibernateDao();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_USER_DAO)
    public IUserDao getIUserDao() {
    	return new UserHibernateDao();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_TOPIC_DAO_INJECTOR)
    public ITopicDaoInjectorService getTopicHibernateDaoInjectorService() {
    	return new TopicHibernateDaoInjectorService();
    }
	
    @Bean
    @Qualifier(Constants.QUALIFY_MESSAGE_DAO_INJECTOR)
    public IMessageDaoInjectorService getMessageHibernateDaoInjectorService() {
    	return new MessageHibernateDaoInjectorService();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_QUESTION_DAO_INJECTOR)
    public IQuestionDaoInjectorService getQuestionHibernateDaoInjectorService() {
    	return new QuestionHibernateDaoInjectorService();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_RANK_DAO_INJECTOR)
    public IRankDaoInjectorService getRankHibernateDaoInjectorService() {
    	return new RankHibernateDaoInjectorService();
    }
    
    @Bean
    @Qualifier(Constants.QUALIFY_USER_DAO_INJECTOR)
    public IUserDaoInjectorService getUserHibernateDaoInjectorService() {
    	return new UserHibernateDaoInjectorService();
    }
      
    
}
