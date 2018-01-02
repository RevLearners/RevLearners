package io.revlearners.model.services.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface ICrudService<TEntity>
{
    boolean exists(Serializable id);

    TEntity findOne(Serializable id);
    
    List<TEntity> findAll();
    
    Page<TEntity> pageAll(int low, int high);
    
    void delete(Serializable id);

    TEntity update(TEntity entity);
    
    TEntity create(TEntity entity);
    
    List<TEntity> create(List<TEntity> entities);
}