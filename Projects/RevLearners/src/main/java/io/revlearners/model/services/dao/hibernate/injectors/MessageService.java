package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Message;
import io.revlearners.model.dao.interfaces.IMessageDao;
import io.revlearners.model.services.dao.interfaces.contracts.IMessageService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class MessageService extends AbstractHibernateService<Message> implements IMessageService{

	@Autowired
	@Qualifier(Constants.QUALIFY_MESSAGE_DAO)
	private IMessageDao dao;
	
	@Override
	protected IGenericDao<Message> getDao() {
		return dao;
	}
}
