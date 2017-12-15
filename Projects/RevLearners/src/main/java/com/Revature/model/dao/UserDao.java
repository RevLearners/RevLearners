package com.Revature.model.dao;

import org.springframework.stereotype.Repository;

import com.Revature.model.bean.UserBean;
import com.Revature.util.hibernate.AbstractHibernateDao;

@Repository
public class UserDao extends AbstractHibernateDao<UserBean> implements IUserDao {
	

}
