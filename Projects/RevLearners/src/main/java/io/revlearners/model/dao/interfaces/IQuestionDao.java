package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.Topic;

import java.util.Set;

public interface IQuestionDao extends IBeanDao {

    Set<Question> fetchRandomQuestionsByTopic(int amt, Topic topic);
}
