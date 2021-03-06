package io.revlearners.util.persistence.interfaces;

import java.io.Serializable;
import java.util.List;


/**
 * Generic Dao interface for all Daos.
 * <p>
 * This interface was made in conjunction with Spring
 * best practices
 * Session allows user to pass in their persistence manager's
 * session handler. This allows for JPA or Hibernate sessions
 *      (we would just have to change the session to EntityMangers)
 * to be persisted to the database
 */
public interface IGenericDao {

	public <T extends Serializable> T fetchSubTypeById(Class<T> clazz, final Serializable id);

	public <T extends Serializable> List<T> fetchAllSubTypes(Class<T> clazz);

	public <T extends Serializable> Serializable create(final T entity);

	public <T extends Serializable> T update(Class<T> clazz, final T entity);

	public <T extends Serializable> void delete(final T entity);

	public<T extends Serializable> void deleteById(Class<T> clazz, final Serializable id);

}
