package io.revlearners.util.commons.configs;

import io.revlearners.model.bean.InboxItem;
import org.hibernate.SessionFactory;
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

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.Properties;



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
                InboxItem.class
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
}
