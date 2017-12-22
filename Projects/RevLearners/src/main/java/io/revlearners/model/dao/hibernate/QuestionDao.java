package io.revlearners.model.dao.hibernate;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Question;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import io.revlearners.util.persistence.hibernate.AbstractHibernateDao;

@Repository
@Scope( BeanDefinition.SCOPE_PROTOTYPE )
public class QuestionDao extends AbstractHibernateDao<Question> implements IQuestionDao {

	public QuestionDao() {
		super();
		setClazz(Question.class);
	}
}
