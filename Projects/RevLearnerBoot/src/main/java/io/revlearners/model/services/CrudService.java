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

import io.revlearners.model.dao.interfaces.IBaseRepository;
import io.revlearners.model.services.interfaces.ICrudService;

public class CrudService<TEntity, TModel> implements ICrudService<TEntity, TModel> {
	@Autowired
	protected IBaseRepository<TEntity> repository;

	@Autowired
	protected ModelMapper modelMapper;

	protected Class<TEntity> entityClass;
	protected Class<TModel> modelClass;

	@SuppressWarnings("unchecked")
	public CrudService() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<TEntity>) genericSuperclass.getActualTypeArguments()[0];
		this.modelClass = (Class<TModel>) genericSuperclass.getActualTypeArguments()[1];
	}

	public TModel findOne(Serializable id) {
		TEntity entity = repository.findOne(id);
		return modelMapper.map(entity, modelClass);
	}

	public List<TModel> findAll() {
		List<TModel> result = new ArrayList<>();
		List<TEntity> entities = repository.findAll();
		for (TEntity entity : entities) {
			result.add(modelMapper.map(entity, modelClass));
		}
		return result;
	}

	public void update(TModel model) {
		TEntity entity = modelMapper.map(model, entityClass);
		repository.saveAndFlush(entity);
	}

	public void deleteById(Long id) {
		TEntity entity = repository.findOne(id);
		repository.saveAndFlush(entity);
	}

	public void create(TModel model) {
		TEntity entity = modelMapper.map(model, entityClass);
		repository.saveAndFlush(entity);
	}

	// Completely generica pager
	@Override
	public Page<TModel> pageAll(int page, int size) {
		Page<TEntity> pages = repository.findAll(new PageRequest(page, size));
		return mapPages(pages);
	}

	private Page<TModel> mapPages(Page<TEntity> pages) {
		return pages.map(new Converter<TEntity, TModel>() {

			@Override
			public TModel convert(TEntity entity) {
				return modelMapper.map(entity, modelClass);
			}
		});
	}

	@Override
	public TEntity findOneEntity(Serializable id) {
		return repository.findOne(id);
	}

	@Override
	public List<TEntity> findAllEntities(Serializable id) {
		return repository.findAll();
	}
}