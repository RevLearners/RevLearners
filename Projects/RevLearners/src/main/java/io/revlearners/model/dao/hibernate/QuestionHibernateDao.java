package io.revlearners.model.dao.hibernate;

import io.revlearners.model.bean.Question;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

public class QuestionHibernateDao extends AbstractHibernateDao<Question> implements IQuestionDao {

	public QuestionHibernateDao() {
		setClazz(Question.class);
	}
}
