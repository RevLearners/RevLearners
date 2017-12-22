package io.revlearners.model.dao.hibernate;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.dao.interfaces.IRankDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class RankDao extends AbstractHibernateDao<Rank> implements IRankDao {

	public RankDao() {
		super();
		setClazz(Rank.class);
	}
}
