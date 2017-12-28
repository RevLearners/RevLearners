package io.revlearners.model.services.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

import io.revlearners.model.bo.RankBo;

public interface ICrudService<TEntity, TModel>
{
    TModel findOne(Serializable id);
    
    TEntity findOneEntity(Serializable id);

    List<TEntity> findAllEntities(Serializable id);
 
    List<TModel> findAll();
    
    Page<TModel> pageAll(int low, int high);
    
    void deleteById(Long id);
}