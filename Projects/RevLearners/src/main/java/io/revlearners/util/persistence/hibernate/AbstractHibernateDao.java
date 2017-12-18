package io.revlearners.util.persistence.hibernate;

import java.io.Serializable;
import java.util.List;

import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.AbstractDao;
import io.revlearners.util.persistence.interfaces.IGenericDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

// Spring loaded parameterized generic dao implementation

/**
 * Spring loaded parameterized generic dao implementation
 *
 * Uses Spring annotations and Java reflections to create a single 
 * Dao implement to be used across all entities
 *
 * This class was made in conjunction with Spring best practices
 */
public class AbstractHibernateDao<T extends Serializable> extends AbstractDao<T> implements IGenericDao<T> {
	
	@Autowired
	private SessionFactory sf;

	protected final Session getSession() {
		return sf.getCurrentSession();
	}
	
	@Override
	public T fetchById(long id) {
        return clazz.cast(sf.getCurrentSession().get(clazz, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> fetchAll(){
		return sf.getCurrentSession().createQuery(Constants.FROM + clazz.getName()).list();
	}

//	public List<T> findByEntity(T entity) {
//		return null;
//	}
	
	@Override
	public void create(final T entity) {
		sf.getCurrentSession().persist(entity);
	}
	
	@Override
	public T update(final T entity) {
		return clazz.cast(sf.getCurrentSession().merge(entity));
	}
	
	@Override
	public void delete(final T entity) {
		sf.getCurrentSession().delete(entity);
	}
	
	@Override
	public void deleteById(final long id) {
		final T entity = fetchById(id);
		delete(entity);
	}
}
