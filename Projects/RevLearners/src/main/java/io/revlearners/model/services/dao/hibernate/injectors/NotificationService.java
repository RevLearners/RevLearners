package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Notification;
import io.revlearners.model.dao.interfaces.INotificationDao;
import io.revlearners.model.services.dao.interfaces.contracts.INotificationService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class NotificationService extends AbstractHibernateService<Notification> implements INotificationService {

	@Override
	protected IGenericDao<Notification> getDao() {
		return dao;
	}
	@Autowired
	@Qualifier(Constants.QUALIFY_NOTIFICATION_DAO)
	private INotificationDao dao;
	
}
