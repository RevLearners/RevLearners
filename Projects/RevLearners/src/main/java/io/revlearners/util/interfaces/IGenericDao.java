package io.revlearners.util.interfaces;

import java.io.Serializable;
import java.util.List;

// Generic Dao interface for all Daos. 

// This interface was made in conjunction with Spring
// best practices
public interface IGenericDao<T extends Serializable> {
	
	T fetchById(final long id);
	
	List<T> fetchAll();
	
	List<T> findByEntity(final T entity);
	
	T makePersistent(final T entity);
	
	void makeTransient(final T entity);

}
