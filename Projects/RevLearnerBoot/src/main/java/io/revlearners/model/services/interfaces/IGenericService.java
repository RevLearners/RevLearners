package io.revlearners.model.services.interfaces;

import java.io.Serializable;
import java.util.List;

public interface IGenericService<TEntity> {
    TEntity findOne(Serializable id);

    List<TEntity> findAll();

    TEntity save(TEntity entity);

    boolean exists(Serializable id);

    void delete(Serializable id);
}
