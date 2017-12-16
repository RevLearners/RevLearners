package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Language;
import io.revlearners.model.dao.interfaces.ILanguageDao;
import io.revlearners.model.services.dao.interfaces.contracts.ILanguageDaoInjectorService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class LanguageHibernateDaoInjectorService extends AbstractHibernateDaoInjectorService<Language> implements ILanguageDaoInjectorService {
	@Autowired
	@Qualifier(Constants.QUALIFY_LANGUAGE_HIBERNATE_DAO)
	private ILanguageDao dao;
	
	@Override
	protected IGenericDao<Language> getDao() {
		return dao;
	}
}
