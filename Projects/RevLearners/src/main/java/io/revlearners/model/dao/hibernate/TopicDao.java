package io.revlearners.model.dao.hibernate;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.ITopicDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
public class TopicDao extends AbstractHibernateDao<Topic> implements ITopicDao {
	
	public TopicDao() {
		super();
		setClazz(Topic.class);
	}
}
