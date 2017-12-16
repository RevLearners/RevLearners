package io.revlearners.model.dao;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.User;
import io.revlearners.util.hibernate.AbstractHibernateDao;

@Repository
public class UserDao extends AbstractHibernateDao<User> implements IUserDao {


}
