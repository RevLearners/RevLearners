package io.revlearners.util.persistence.hibernate;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import io.revlearners.util.persistence.AbstractService;
import io.revlearners.util.persistence.interfaces.IGenericDao;
import io.revlearners.util.commons.configs.Constants;

@Transactional(value = Constants.TRANSACTION_HIBERNATE_MANAGER)
public abstract class AbstractHibernateService<T extends Serializable> extends AbstractService<T> implements IGenericDao<T> {

	@Override
	public T fetchById(long id) {
		return super.fetchById(id);
	}

	@Override
	public List<T> fetchAll() {
		return super.fetchAll();
	}

	@Override
	public void create(T entity) {
		super.create(entity);
	}

	@Override
	public T update(T entity) {
		return super.update(entity);
	}

	@Override
	public void delete(T entity) {
		super.delete(entity);
	}

	@Override
	public void deleteById(long id) {
		super.deleteById(id);		
	}
	
}
