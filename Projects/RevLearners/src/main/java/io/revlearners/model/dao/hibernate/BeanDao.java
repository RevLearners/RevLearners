package io.revlearners.model.dao.hibernate;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.IBeanDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class BeanDao extends AbstractHibernateDao<Topic> implements IBeanDao {
	
	public BeanDao() {
		super();
		setClazz(Topic.class);
	}
}
