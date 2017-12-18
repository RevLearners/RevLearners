package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.ITopicDao;
import io.revlearners.model.services.dao.interfaces.contracts.ITopicService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class TopicService extends AbstractHibernateService<Topic> implements ITopicService {
	@Autowired
	@Qualifier(Constants.QUALIFY_TOPIC_DAO)
	private ITopicDao dao;
	
	@Override
	protected IGenericDao<Topic> getDao() {
		return dao;
	}
}
