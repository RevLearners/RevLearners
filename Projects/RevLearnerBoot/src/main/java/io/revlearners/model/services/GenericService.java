package io.revlearners.model.services;

import io.revlearners.model.dao.interfaces.IGenericRepository;
import io.revlearners.model.services.interfaces.IGenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class GenericService<TEntity> implements IGenericService<TEntity> {

    @Autowired
    protected IGenericRepository<TEntity> genericRepo;

    @Override
    public boolean exists(Serializable id) {
        return genericRepo.exists(id);
    }

    @Override
    public TEntity findOne(Serializable id) {
        return genericRepo.findOne(id);
    }

    @Override
    public List<TEntity> findAll() {
        return genericRepo.findAll();
    }

    @Override
    public TEntity save(TEntity entity) {
        return genericRepo.save(entity);
    }

    @Override
    public void delete(Serializable id) {
        genericRepo.delete(id);
    }
}
