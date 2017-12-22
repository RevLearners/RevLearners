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
public interface IGenericDao {
	
	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, final long id, Object object);
	
	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz, Object object);
	
	public <T extends Serializable> Serializable create(final T entity, Object object);
	
	public <T extends Serializable> T update(Class<T> clazz, final T entity, Object object);
	
	public <T extends Serializable> void delete(final T entity, Object object);
	
	public<T extends Serializable> void deleteById(Class<T> clazz, final long id, Object object);

}
