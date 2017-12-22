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
public abstract class AbstractHibernateDao extends AbstractDao implements IGenericDao {

	@Autowired
	private SessionFactory sf;

	public AbstractHibernateDao() {

	}

	@Override
	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, Serializable id, Object session) {
		if (session == null) {
			return sf.getCurrentSession().get(clazz, id);
		}
		return clazz.cast(((Session) session).get(clazz, id));
	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz, Object session) {
		if (session == null) {
			return sf.getCurrentSession().createQuery(Constants.FROM + clazz.getName()).list();
		}
		return ((Session) session).createQuery(Constants.FROM + clazz.getName()).list();
	}

	@Override
	public <T extends Serializable> Serializable create(final T entity, Object session) {
		if (session == null) {
			return sf.getCurrentSession().save(entity);
		}
		return ((Session) session).save(entity);
	}

	@Override
	public <T extends Serializable> T update(Class<T> clazz, final T entity, Object session) {
		if (session == null) {
			return clazz.cast(sf.getCurrentSession().merge(entity));
		}
		return clazz.cast(((Session) session).merge(entity));

	}

	@Override
	public <T extends Serializable> void delete(final T entity, Object session) {
		if (session == null) {
			sf.getCurrentSession().delete(entity);
		} else {
			((Session) session).delete(entity);
		}
	}

	@Override
	public <T extends Serializable> void deleteById(Class<T> clazz, final Serializable id, Object session) {
		final T entity = fetchSubTypeById(clazz, id, session);
		delete(entity, session);
	}
}
