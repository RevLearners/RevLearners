package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.Topic;
import org.hibernate.Session;

import java.util.List;

public interface IQuestionDao extends IBeanDao {

    List<Question> fetchRandomQuestionsByTopic(int amt, Topic topic);
}
