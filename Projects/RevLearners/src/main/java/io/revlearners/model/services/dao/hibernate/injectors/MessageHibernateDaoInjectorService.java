package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Message;
import io.revlearners.model.dao.interfaces.IMessageDao;
import io.revlearners.model.services.dao.interfaces.contracts.IMessageDaoInjectorService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class MessageHibernateDaoInjectorService extends AbstractHibernateDaoInjectorService<Message> implements IMessageDaoInjectorService{
	@Autowired
	@Qualifier(Constants.QUALIFY_MESSAGE_HIBERNATE_DAO)
	private IMessageDao dao;
	
	@Override
	protected IGenericDao<Message> getDao() {
		return dao;
	}
}
