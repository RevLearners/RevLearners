package io.revlearners.model.dao;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.UserBean;
import io.revlearners.util.hibernate.AbstractHibernateDao;

@Repository
public class UserDao extends AbstractHibernateDao<UserBean> implements IUserDao {
	

}
