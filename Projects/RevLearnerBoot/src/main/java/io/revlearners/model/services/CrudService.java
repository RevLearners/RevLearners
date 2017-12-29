package io.revlearners.model.services;

import java.io.Serializable;

import java.lang.reflect.ParameterizedType;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.revlearners.model.dao.interfaces.IBaseRepository;
import io.revlearners.model.services.interfaces.ICrudService;

public abstract class CrudService<TEntity> implements ICrudService<TEntity> {
	@Autowired
	protected IBaseRepository<TEntity> repository;

	@Autowired
	protected ModelMapper modelMapper;

	protected Class<TEntity> entityClass;
//	protected Class<TModel> modelClass;

	@SuppressWarnings("unchecked")
	public CrudService() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<TEntity>) genericSuperclass.getActualTypeArguments()[0];
//		this.modelClass = (Class<TModel>) genericSuperclass.getActualTypeArguments()[1];
	}

	public TEntity findOne(Serializable id) {
		return repository.findOne(id);
	}

	public List<TEntity> findAll() {
		return repository.findAll();
	}

	public TEntity update(TEntity entity) {
		return repository.saveAndFlush(entity);
	}

	public void deleteById(Long id) {
		TEntity entity = repository.findOne(id);
		repository.saveAndFlush(entity);
	}

	public TEntity create(TEntity entity) {
		return repository.saveAndFlush(entity);
	}

	// Completely generic pager
	@Override
	public Page<TEntity> pageAll(int page, int size) {
		return repository.findAll(new PageRequest(page, size));
	}

//	private Page<TModel> mapPages(Page<TEntity> pages) {
//		return pages.map(new Converter<TEntity, TModel>() {
//
//			@Override
//			public TModel convert(TEntity entity) {
//				return modelMapper.map(entity, modelClass);
//			}
//		});
//	}

	@Override
	public TEntity findOneEntity(Serializable id) {
		return repository.findOne(id);
	}

	@Override
	public List<TEntity> findAllEntities(Serializable id) {
		return repository.findAll();
	}
}