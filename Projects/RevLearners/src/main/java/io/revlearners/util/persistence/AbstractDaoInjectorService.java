package io.revlearners.util.persistence;

import java.io.Serializable;
import java.util.List;

import io.revlearners.util.persistence.interfaces.IGenericDao;

// Persistence layer injector to inject bean into dao
public abstract class AbstractDaoInjectorService<T extends Serializable> implements IGenericDao<T> {

	@Override
	public T fetchOne(long id) {
		return getDao().fetchOne(id);
	}

	@Override
	public List<T> fetchAll() {
		return getDao().fetchAll();
	}

	@Override
	public void save(T entity) {
		getDao().save(entity);
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
