package io.revlearners.model.services;

import java.io.Serializable;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import io.revlearners.model.dao.interfaces.IBaseRepository;
import io.revlearners.model.services.interfaces.ICrudService;

public abstract class CrudService<TEntity> implements ICrudService<TEntity> {
	@Autowired
	protected IBaseRepository<TEntity> repository;

	@Autowired
	protected ModelMapper modelMapper;

	@Override
    public boolean exists(Serializable id) {
        return repository.exists(id);
    }

    @Override
	public TEntity findOne(Serializable id) {
		return repository.findOne(id);
	}

    @Override
	public List<TEntity> findAll() {
		return repository.findAll();
	}

    @Override
	public TEntity update(TEntity entity) {
		return repository.saveAndFlush(entity);
	}

    @Override
	public void delete(Serializable id) {
		TEntity entity = repository.findOne(id);
		repository.saveAndFlush(entity);
	}

    @Override
	public TEntity create(TEntity entity) {
		return repository.saveAndFlush(entity);
	}

	// Completely generic pager
	@Override
	public Page<TEntity> pageAll(int page, int size) {
		return repository.findAll(new PageRequest(page, size));
	}
}