package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.User;
import io.revlearners.model.dao.interfaces.IUserDao;
import io.revlearners.model.services.dao.interfaces.contracts.IUserDaoInjectorService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class UserHibernateDaoInjectorService extends AbstractHibernateDaoInjectorService<User> implements IUserDaoInjectorService {
	@Autowired
	@Qualifier(Constants.QUALIFY_USER_HIBERNATE_DAO)
	private IUserDao dao;
	
	@Override
	protected IGenericDao<User> getDao() {
		return dao;
	}

}
