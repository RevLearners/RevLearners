package io.revlearners.util.persistence;

import java.io.Serializable;

public interface DaoFactory<T extends Serializable> {

	public AbstractDao<T> createDao(DaoType type);

	public enum DaoMapper {
		HIBERNATE, JPA
	}

	public enum DaoType {
		USER, RANK, MESSAGE, LANGUAGE, QUESTION

	}
}