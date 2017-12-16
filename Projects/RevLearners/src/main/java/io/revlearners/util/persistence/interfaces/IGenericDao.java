package io.revlearners.util.persistence.interfaces;

import java.io.Serializable;
import java.util.List;

// Generic Dao interface for all Daos. 

// This interface was made in conjunction with Spring
// best practices
public interface IGenericDao<T extends Serializable> {
	
	public T fetchOne(final long id);
	
	public List<T> fetchAll();
	
	public void save(final T entity);
	
	public T update(final T entity);
	
	public void delete(final T entity);
	
	public void deleteById(final long id);

}
