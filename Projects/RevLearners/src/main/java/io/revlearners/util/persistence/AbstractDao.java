package io.revlearners.util.persistence;

import java.io.Serializable;

import com.google.common.base.Preconditions;

import io.revlearners.util.persistence.interfaces.IGenericDao;

// Dao is set using DI to inject a parameterized dao with a subclassed dao

public abstract class AbstractDao<T extends Serializable> implements IGenericDao<T> {
	
	protected Class<T> clazz;

	public final void setClazz(Class<T> clazz) {
		clazz = Preconditions.checkNotNull(clazz);
	}
}
