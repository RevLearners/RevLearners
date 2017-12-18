package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.User;
import io.revlearners.model.dao.interfaces.IUserDao;
import io.revlearners.model.services.dao.interfaces.contracts.IUserService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class UserService extends AbstractHibernateService<User> implements IUserService {
	@Autowired
	@Qualifier(Constants.QUALIFY_USER_DAO)
	private IUserDao dao;
	
	@Override
	protected IGenericDao<User> getDao() {
		return dao;
	}

}
