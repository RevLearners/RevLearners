package io.revlearners.util.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import io.revlearners.util.persistence.interfaces.IGenericDao;

// Persistence layer injector to inject bean into dao
public abstract class AbstractService implements IGenericDao {

	@Override
	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, Serializable id, Session session) {
		return getDao().fetchSubTypeById(clazz, id, session);
	}

	@Override
	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz, Session session) {
		return getDao().fetchAllSubTypes(clazz, session);
	}

	@Override
	public <T extends Serializable> Serializable create(T entity, Session session) {
		return getDao().create(entity, session);
	}

	@Override
	public <T extends Serializable> T update(Class<T> clazz, T entity, Session session) {
		return getDao().update(clazz, entity, session);
	}

	@Override
	public <T extends Serializable> void delete(T entity, Session session) {
		getDao().delete(entity, session);
	}

	@Override
	public <T extends Serializable> void deleteById(Class<T> clazz, Serializable id, Session session) {
		getDao().deleteById(clazz, id, session);		
	}
	
	protected abstract IGenericDao getDao();

}
