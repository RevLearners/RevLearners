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
public abstract class AbstractHibernateService extends AbstractService implements IGenericDao {

	@Override
	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, long id, Object session) {
		return super.fetchSubTypeById(clazz, id, session);
	}

	@Override
	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz, Object session) {
		return super.fetchAllSubTypes(clazz, session);
	}

	@Override
	public <T extends Serializable> Serializable create(T entity, Object session) {
		return super.create(entity, session);
	}

	@Override
	public <T extends Serializable> T update(Class<T> clazz, T entity, Object session) {
		return super.update(clazz, entity, session);
	}

	@Override
	public <T extends Serializable> void delete(T entity, Object session) {
		super.delete(entity, session);
	}

	@Override
	public <T extends Serializable> void deleteById(Class<T> clazz, long id, Object session) {
		super.deleteById(clazz, id, session);		
	}
	
}
