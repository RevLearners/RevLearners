package io.revlearners.model.dao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface IGenericRepository<TEntity> extends JpaRepository<TEntity, Serializable> {
}
