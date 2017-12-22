package io.revlearners.model.dao.hibernate;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.User;
import io.revlearners.model.dao.interfaces.IUserDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {

	public UserDao() {
		super();
		setClazz(User.class);
	}
}
