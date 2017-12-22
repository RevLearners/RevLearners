package io.revlearners.model.services;

import io.revlearners.model.bean.*;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class QuestionService {
    @Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;


    /**
     * Each question will contain a Set<QuestionOption> which will
     * contain exactly one option denoting the option selected by
     * the user
     *
     * should match the one in the database except for the fact that
     * the its optoin
     *
     * @param quiz
     * @return
     */
	public double scoreQuiz(Quiz quiz) {
	    Transaction tx = null;

	    try(Session session = sf.openSession()) {
            double score = scoreQuestions(quiz.getQuestions(), session);
            tx = session.beginTransaction();


            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }

        return -1;
	}

    /**
     * calculates the score given a set answered questions
     * assumes only one question is correct per question
     *
     * @param questions
     * @return
     */
    private double scoreQuestions(Set<Question> questions, Session session) {
        double score = 0;
	    for (Question q: questions) {
            QuestionOption selected = (QuestionOption)(q.getOptions().toArray()[0]);
            Question poolQuestion = beanService.fetchSubTypeById(Question.class, q.getId(), session);

            boolean answeredCorrectly = poolQuestion.getOptions().stream()
                    .anyMatch(option -> option.isCorrect() && option.getId().equals(selected.getId()));

            if (answeredCorrectly) {
                score += q.getDifficulty().getMultiplier() * q.getType().getBaseVal();
            }
        }
        return score;
    }

    private void checkRankUp(User user, Rank rank) {

    }


    /**
     * assumes user has enough merit points to rank up in given topic
     *
     * @param user
     * @param topic
     */
    private void rankup(User user, Topic topic) {
        UserRank rankInTopic = user.getRanks().stream()
                .filter(userRank -> userRank.getRank().getTopic().getId() > topic.getId())
                .collect(Collectors.toList())
                .get(0);    // we assume only one match per topic per user

        Rank currentRank = rankInTopic.getRank();
        Rank nextRank = getNextRankForTopic(topic, currentRank);

        rankInTopic.setRank(nextRank);

        // todo: dao stuff to update the UserRank
    }

    /**
     * assumes user has a valid ranks with appropriate rank weights
     * @param topic
     * @param rank
     * @return
     */
    public Rank getNextRankForTopic(Topic topic, Rank rank) {
        Long maxWeight = 0L;
        Rank nextRank = null;
        for (Rank topicRank: topic.getRanks()) {
            Long curRelWeight = topicRank.getRelativeWeight();
            if (maxWeight < curRelWeight)
                maxWeight = curRelWeight;
            if (rank.getRelativeWeight().equals(curRelWeight + 1))
                nextRank = topicRank;
        }
        if (rank.getRelativeWeight().equals(maxWeight)) {
            return rank;
        }
        return nextRank;
    }

    public List<Question> generateQuestions(Long n, Topic category) {
	    Transaction tx = null;
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();




            session.getTransaction().commit();
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }

        return null;
    }

}
