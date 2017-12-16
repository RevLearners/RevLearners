package io.revlearners.model.dao.hibernate;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.dao.interfaces.IRankDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
public class RankHibernateDao extends AbstractHibernateDao<Rank> implements IRankDao {

	public RankHibernateDao() {
		super();
		setClazz(Rank.class);
	}
}
