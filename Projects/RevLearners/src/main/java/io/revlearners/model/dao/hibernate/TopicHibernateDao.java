package io.revlearners.model.dao.hibernate;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.ITopicDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

public class TopicHibernateDao extends AbstractHibernateDao<Topic> implements ITopicDao {
	
	public TopicHibernateDao() {
		setClazz(Topic.class);
	}
}
