package com.Revature.util.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.Revature.util.interfaces.IGenericDao;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class GenericHibernateDao<T extends Serializable> extends AbstractHibernateDao<T> implements IGenericDao<T> {

	@Override
	public T fetchById(long id) {
		return null;
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
