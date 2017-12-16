package io.revlearners.util.persistence.hibernate;

import java.io.Serializable;

import io.revlearners.util.persistence.AbstractDaoInjectorService;
import io.revlearners.util.persistence.interfaces.IGenericDao;

public abstract class AbstractHibernateDaoInjectorService<T extends Serializable> extends AbstractDaoInjectorService<T> implements IGenericDao<T> {

}
