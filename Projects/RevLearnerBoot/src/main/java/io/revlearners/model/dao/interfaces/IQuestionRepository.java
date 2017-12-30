package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Set;

@Repository
public interface IQuestionRepository extends IGenericRepository<Question> {

    /**
     * generate a random set of questions that match
     * given topic
     *
     * apparently the @Param annotations means that spring will call
     * the named query defined in the Question hibernate bean
     *
     * @param topicId
     * @param numQuestions
     * @return
     */
    Set<Question> generateQuestions(@Param("topicId") long topicId, @Param("numQuestions") int numQuestions);
}
