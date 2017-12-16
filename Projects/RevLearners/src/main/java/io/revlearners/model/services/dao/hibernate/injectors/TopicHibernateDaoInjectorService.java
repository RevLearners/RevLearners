package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Language;
import io.revlearners.model.dao.interfaces.ITopicDao;
import io.revlearners.model.services.dao.interfaces.contracts.ITopicDaoInjectorService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class TopicHibernateDaoInjectorService extends AbstractHibernateDaoInjectorService<Topic> implements ITopicDaoInjectorService {
	@Autowired
	@Qualifier(Constants.QUALIFY_TOPIC_HIBERNATE_DAO)
	private ITopicDao dao;
	
	@Override
	protected IGenericDao<Topic> getDao() {
		return dao;
	}
}
