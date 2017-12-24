package io.revlearners.util.persistence.hibernate;

import java.io.Serializable;
import java.util.List;

import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.AbstractDao;
import io.revlearners.util.persistence.interfaces.IGenericDao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

// Spring loaded parameterized generic dao implementation

/**
 * Spring loaded parameterized generic dao implementation
 *
 * Uses Spring annotations and Java reflections to create a single Dao implement
 * to be used across all entities
 *
 * This class was made in conjunction with Spring best practices
 */
@Transactional(value = Constants.TRANSACTION_HIBERNATE_MANAGER)
public abstract class AbstractHibernateDao extends AbstractDao implements IGenericDao {

	@Autowired
    protected SessionFactory sf;

	public AbstractHibernateDao() {
	}

	@Override
	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, Serializable id) {
		return sf.getCurrentSession().get(clazz, id);

	}

	@Override
	@SuppressWarnings("unchecked")
	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz) {
		return sf.getCurrentSession().createQuery(Constants.FROM + clazz.getName()).list();
	}

	@Override
	public <T extends Serializable> Serializable create(final T entity) {
		return sf.getCurrentSession().save(entity);
	}

	@Override
	public <T extends Serializable> T update(Class<T> clazz, final T entity) {
		return clazz.cast(sf.getCurrentSession().merge(entity));
	}

	@Override
	public <T extends Serializable> void delete(final T entity) {
		sf.getCurrentSession().delete(entity);
	}

	public Session getSession() {
		return sf.getCurrentSession();
	}

	@Override
	public <T extends Serializable> void deleteById(Class<T> clazz, final Serializable id) {
		final T entity = fetchSubTypeById(clazz, id);
		delete(entity);
	}
}
