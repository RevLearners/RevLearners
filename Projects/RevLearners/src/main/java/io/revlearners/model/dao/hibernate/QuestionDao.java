package io.revlearners.model.dao.hibernate;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Question;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
public class QuestionDao extends AbstractHibernateDao<Question> implements IQuestionDao {

	public QuestionDao() {
		super();
		setClazz(Question.class);
	}
}
