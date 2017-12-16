package io.revlearners.model.services.dao.hibernate.injectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.dao.interfaces.IRankDao;
import io.revlearners.model.services.dao.interfaces.contracts.IRankDaoInjectorService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

@Service
public class RankHibernateDaoInjectorService extends AbstractHibernateDaoInjectorService<Rank> implements IRankDaoInjectorService {
	@Autowired
	@Qualifier(Constants.QUALIFY_RANK_DAO)
	private IRankDao dao;
	
	@Override
	protected IGenericDao<Rank> getDao() {
		return dao;
	}
}
