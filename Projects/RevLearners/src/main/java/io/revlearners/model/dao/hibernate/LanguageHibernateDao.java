package io.revlearners.model.dao.hibernate;

import io.revlearners.model.bean.Language;
import io.revlearners.model.dao.interfaces.ILanguageDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

public class LanguageHibernateDao extends AbstractHibernateDao<Language> implements ILanguageDao {
	
	public LanguageHibernateDao() {
		setClazz(Language.class);
	}
}
