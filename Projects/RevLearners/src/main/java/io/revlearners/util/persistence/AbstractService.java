package io.revlearners.util.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import io.revlearners.util.persistence.interfaces.IGenericDao;

// Persistence layer injector to inject bean into dao
public abstract class AbstractService<T extends Serializable> implements IGenericDao<T> {

	@Override
	public T fetchById(long id, Object session) {
		return getDao().fetchById(id, session);
	}

	@Override
	public List<T> fetchAll(Object session) {
		return getDao().fetchAll(session);
	}
	
	@Override
	public <U> U fetchDependencyById(Class<U> clazz, long id, Object session) {
		return getDao().fetchDependencyById(clazz, id, session);
	}

	@Override
	public Serializable create(T entity, Object session) {
		return getDao().create(entity, session);
	}

	@Override
	public T update(T entity, Object session) {
		return getDao().update(entity, session);
	}

	@Override
	public void delete(T entity, Object session) {
		getDao().delete(entity, session);
	}

	@Override
	public void deleteById(long id, Object session) {
		getDao().deleteById(id, session);		
	}
	
	protected abstract IGenericDao<T> getDao();

}
