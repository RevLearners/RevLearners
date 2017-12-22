package io.revlearners.util.persistence.hibernate;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.transaction.annotation.Transactional;

import io.revlearners.util.persistence.AbstractService;
import io.revlearners.util.persistence.interfaces.IGenericDao;
import io.revlearners.util.commons.configs.Constants;

@Transactional(value = Constants.TRANSACTION_HIBERNATE_MANAGER)
public abstract class AbstractHibernateService<T extends Serializable> extends AbstractService<T> implements IGenericDao<T> {

	@Override
	public T fetchById(long id, Object session) {
		return super.fetchById(id, session);
	}

	@Override
	public List<T> fetchAll(Object session) {
		return super.fetchAll(session);
	}
	
	@Override
	public <U> U fetchDependencyById(Class<U> clazz, long id, Object session) {
		return super.fetchDependencyById(clazz, id, session);
		
	}

	@Override
	public Serializable create(T entity, Object session) {
		return super.create(entity, session);
	}

	@Override
	public T update(T entity, Object session) {
		return super.update(entity, session);
	}

	@Override
	public void delete(T entity, Object session) {
		super.delete(entity, session);
	}

	@Override
	public void deleteById(long id, Object session) {
		super.deleteById(id, session);		
	}
	
}
