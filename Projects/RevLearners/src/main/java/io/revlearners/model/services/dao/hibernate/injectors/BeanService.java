package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.IBeanDao;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class BeanService extends AbstractHibernateService implements IBeanService {
	@Autowired
	@Qualifier(Constants.QUALIFY_HIBERNATE_BEAN_DAO)
	private IBeanDao dao;
	
	@Override
	protected IGenericDao getDao() {
		return dao;
	}
}
