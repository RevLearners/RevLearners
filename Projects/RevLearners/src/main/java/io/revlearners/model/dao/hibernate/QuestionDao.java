package io.revlearners.model.dao.hibernate;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.dao.interfaces.IQuestionDao;
import org.hibernate.Session;

import javax.persistence.Query;
import javax.persistence.criteria.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QuestionDao extends BeanDao implements IQuestionDao {

    @Override
    public Set<Question> fetchRandomQuestionsByTopic(int amt, Topic topic) {
        Session session = sf.getCurrentSession();
        Query hql = session.createNamedQuery("fetchRandomQuestions", Question.class)   // todo: use constants
                .setMaxResults(amt);
        hql.setParameter("topicId", topic.getId());
        List<Question> randomQs = hql.getResultList();
        return new HashSet<>(randomQs);
    }

    private Path<Topic> getQTopicPath(Root<Question> questionsRoot) {
        return questionsRoot.<Topic>get("topic");
    }
}
