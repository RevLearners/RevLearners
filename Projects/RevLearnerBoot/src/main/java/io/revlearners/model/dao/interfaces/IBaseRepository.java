package io.revlearners.model.dao.interfaces;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<TEntity> extends JpaRepository<TEntity, Serializable> {
}