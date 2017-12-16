package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Question;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import io.revlearners.model.services.dao.interfaces.contracts.IQuestionDaoInjectorService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class QuestionHibernateDaoInjectorService extends AbstractHibernateDaoInjectorService<Question> implements IQuestionDaoInjectorService {

	@Autowired
	@Qualifier(Constants.QUALIFY_QUESTION_HIBERNATE_DAO)
	private IQuestionDao dao;
	
	@Override
	protected IGenericDao<Question> getDao() {
		return dao;
	}
}
