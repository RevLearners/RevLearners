package io.revlearners.util.persistence;

import java.io.Serializable;
import java.util.List;

import io.revlearners.util.persistence.interfaces.IGenericDao;

// Persistence layer injector to inject bean into dao
public abstract class AbstractService<T extends Serializable> implements IGenericDao<T> {

	@Override
	public T fetchById(long id) {
		return getDao().fetchById(id);
	}

	@Override
	public List<T> fetchAll() {
		return getDao().fetchAll();
	}

	@Override
	public void create(T entity) {
		getDao().create(entity);
	}

	@Override
	public T update(T entity) {
		return getDao().update(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void deleteById(long id) {
		getDao().deleteById(id);		
	}
	
	protected abstract IGenericDao<T> getDao();

}
