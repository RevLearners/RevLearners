package io.revlearners.model.dao.interfaces;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserCertification;

@NoRepositoryBean
public interface IBaseRepository<TEntity> extends JpaRepository<TEntity, Serializable> {

}