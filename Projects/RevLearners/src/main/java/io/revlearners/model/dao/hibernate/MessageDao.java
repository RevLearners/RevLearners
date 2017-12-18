package io.revlearners.model.dao.hibernate;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Message;
import io.revlearners.model.dao.interfaces.IMessageDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
public class MessageDao extends AbstractHibernateDao<Message> implements IMessageDao{

	public MessageDao() {
		super();
		setClazz(Message.class);
	}
}
