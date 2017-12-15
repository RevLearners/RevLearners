package com.Revature.util.hibernate;

public abstract class DaoFactory {

	public static final Class<? extends DaoFactory> DHF = DaoHibernateFactory.class;

	public static DaoFactory instance(Class<? extends DaoFactory> factory) {
		try {
			return (DaoFactory) factory.newInstance();
		} catch (Exception ex) {
			throw new RuntimeException("Couldn't create DAOFactory: " + factory);
		}
	}

	// Add your DAO interfaces here
}