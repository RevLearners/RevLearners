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
 * Uses Spring annotations and Java reflections to create a single Dao implement
 * to be used across all entities
 *
 * This class was made in conjunction with Spring best practices
 */
public class AbstractHibernateDao<T extends Serializable> extends AbstractDao<T> implements IGenericDao<T> {

	@Autowired
	private SessionFactory sf;

	public AbstractHibernateDao() {

	}

	@Override
	public T fetchById(long id, Object session) {
		if (session == null) {
			return sf.getCurrentSession().get(clazz, id);
		}
		return clazz.cast(((Session) session).get(clazz, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> fetchAll(Object session) {
		if (session == null) {
			return sf.getCurrentSession().createQuery(Constants.FROM + clazz.getName()).list();
		}
		return ((Session) session).createQuery(Constants.FROM + clazz.getName()).list();
	}

	// public List<T> findByEntity(T entity) {
	// return null;
	// }

	@Override
	public Serializable create(final T entity, Object session) {
		if (session == null) {
			return sf.getCurrentSession().save(entity);
		}
		return ((Session) session).save(entity);
	}

	@Override
	public T update(final T entity, Object session) {
		if (session == null) {
			return clazz.cast(sf.getCurrentSession().merge(entity));
		}
		return clazz.cast(((Session) session).merge(entity));

	}

	@Override
	public void delete(final T entity, Object session) {
		if (session == null) {
			sf.getCurrentSession().delete(entity);
		} else {
			((Session) session).delete(entity);
		}
	}

	@Override
	public void deleteById(final long id, Object session) {
		final T entity = fetchById(id, session);
		delete(entity, session);
	}
}
