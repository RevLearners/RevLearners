package io.revlearners.model.dao.hibernate;

import io.revlearners.model.bean.Message;
import io.revlearners.model.dao.interfaces.IMessageDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

public class MessageHibernateDao extends AbstractHibernateDao<Message> implements IMessageDao{

	public MessageHibernateDao() {
		setClazz(Message.class);
	}
}
