package io.revlearners.model.services.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import io.revlearners.model.bo.RankBo;

public interface ICrudService<TEntity>
{
    TEntity findOne(Serializable id);
    
    TEntity findOneEntity(Serializable id);

    List<TEntity> findAllEntities(Serializable id);
 
    List<TEntity> findAll();
    
    Page<TEntity> pageAll(int low, int high);
    
    void deleteById(Long id);
    
    TEntity update(TEntity entity);
    
    TEntity create(TEntity entity);
}