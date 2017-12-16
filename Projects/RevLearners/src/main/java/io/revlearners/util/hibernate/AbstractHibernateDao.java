package io.revlearners.util.hibernate;

import java.io.Serializable;
import java.util.List;

import io.revlearners.util.configs.Constants;
import io.revlearners.util.interfaces.IGenericDao;
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
public class AbstractHibernateDao<T extends Serializable> implements IGenericDao<T> {

	private Class<T> clazz;
	
	@Autowired
	private SessionFactory sf;
	
	public final void setClazz(Class<T> clazz) {
		this.clazz = clazz;
	}

	protected final Session getSession() {
		return sf.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<T> fetchAll(){
		return sf.getCurrentSession().createQuery(Constants.FROM + clazz.getName()).list();
	}

	@Override
	public T fetchById(long id) {
        return clazz.cast(sf.getCurrentSession().get(clazz, id));
	}

	@Override
	public List<T> findByEntity(T entity) {
		return null;
	}

	@Override
	public T makePersistent(T entity) {
		return null;
	}

	@Override
	public void makeTransient(T entity) {

	}
}
