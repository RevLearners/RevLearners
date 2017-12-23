package io.revlearners.util.persistence;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;
import io.revlearners.util.persistence.interfaces.IGenericDao;

// Persistence layer injector to inject bean into dao
public abstract class AbstractService implements IGenericDao {

	@Override
	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, long id) {
		return getDao().fetchSubTypeById(clazz, id);
	}

	@Override
	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz) {
		return getDao().fetchAllSubTypes(clazz);
	}

	@Override
	public <T extends Serializable> Serializable create(T entity) {
		return getDao().create(entity);
	}

	@Override
	public <T extends Serializable> T update(Class<T> clazz, T entity) {
		return getDao().update(clazz, entity);
	}

	@Override
	public <T extends Serializable> void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public <T extends Serializable> void deleteById(Class<T> clazz, long id) {
		getDao().deleteById(clazz, id);		
	}
	
	protected abstract IGenericDao getDao();

}
