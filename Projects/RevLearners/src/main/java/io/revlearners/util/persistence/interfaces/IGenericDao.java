package io.revlearners.util.persistence.interfaces;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;

// Generic Dao interface for all Daos. 

// This interface was made in conjunction with Spring
// best practices
// Object allows user to pass in their persistence manager's
// session handler. This allows for JPA or Hibernate sessions
// to be persisted to the database
public interface IGenericDao<T extends Serializable> {
	
	public T fetchById(final long id, Object object);
	
	public List<T> fetchAll(Object object);
	
	public Serializable create(final T entity, Object object);
	
	public T update(final T entity, Object object);
	
	public void delete(final T entity, Object object);
	
	public void deleteById(final long id, Object object);

}
