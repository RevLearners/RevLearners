package io.revlearners.model.dao.hibernate;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.IQuestionDao;

import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.List;

public class QuestionDao extends BeanDao implements IQuestionDao {


    @Override
    public List<Question> fetchRandomQuestionsByTopic(int amt, Topic topic, Session session) {
        Query hql = session.createNamedQuery("fetchRandomQuestions", Question.class)   // todo: use constants
                .setMaxResults(amt);
        hql.setParameter("topicId", topic.getId());
        List<Question> randomQs = hql.getResultList();
        return randomQs;
    }

    private Path<Topic> getQTopicPath(Root<Question> questionsRoot) {
        return questionsRoot.<Topic>get("topic");
    }
}
