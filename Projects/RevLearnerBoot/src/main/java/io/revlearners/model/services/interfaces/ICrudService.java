package io.revlearners.model.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

public interface ICrudService<TEntity, TModel>
{
    TModel findOne(Long id);
 
    List<TModel> findAll();
    
    Page<TModel> pageAll(int low, int high);
 
    void update(TModel model);
 
    void deleteById(Long id);
 
    void create(TModel model);
}