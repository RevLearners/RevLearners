package io.revlearners.util.persistence.hibernate;

import java.io.Serializable;

import io.revlearners.model.dao.hibernate.*;
import io.revlearners.util.persistence.AbstractDao;
import io.revlearners.util.persistence.DaoFactory;

public class DaoHibernateFactory<T extends Serializable> implements DaoFactory<T> {

	DaoHibernateFactory factory;
	
	private DaoHibernateFactory() {
		
	}
	
	@Override
	public AbstractDao<T> createDao(DaoType type) {
		if(factory == null) {
			factory = new DaoHibernateFactory<T>();
		}
		
		switch(type){
		case USER:
			break;
		case MESSAGE:
			break;
		}
		
		return null;
	}


}
