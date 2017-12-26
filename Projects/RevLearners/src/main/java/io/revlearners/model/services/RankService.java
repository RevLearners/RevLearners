package io.revlearners.model.services;

import java.util.stream.Collectors;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRank;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;

public class RankService {
    @Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;
	
    /**
     * required: user must only have one rank per topic
     * @param user
     * @param topic
     */
	public UserRank getUserRank(User user, Topic topic) {
		UserRank rankInTopic = user.getRanks().stream()
    			.filter(userRank -> userRank.getRank().getTopic().getId() > topic.getId())
    			.collect(Collectors.toList())
    			.get(0);
    	
    	return rankInTopic;
	}
	
    /**
     * required: user must only have one rank per topic
     * @param user
     * @param topic
     */
	public Long getMeritPts(User user, Topic topic) {
		UserRank rankInTopic = getUserRank(user, topic);
    	return rankInTopic.getMerit();
	}
	
    /**
     * required: user must only have one rank per topic
     * @param user
     * @param topic
     * @param meritPts: merit Points
     */
	public void setMeritPts(User user, Topic topic, Long meritPts) {
		UserRank rankInTopic = getUserRank(user, topic);
		rankInTopic.setMerit(meritPts);
	}
	
    /**
     * assumes user has enough merit points to rank up in a given topic
     * @param user
     * @param topic
     */
    private void rankup(User user, Topic topic) {
    	Transaction tx = null;
    	UserRank rankInTopic = getUserRank(user, topic);
    	Rank currentRank = rankInTopic.getRank();
    	Rank nextRank = getNextRankForTopic(topic, currentRank);
    	
    	UserRank oldUserRank = rankInTopic;
    	rankInTopic.setRank(nextRank);
    	
    	//QUESTION - should the below code be implemented a separate dao class?
	    try(Session session = sf.openSession()) {
            tx = session.beginTransaction();
            //beanService.update(UserRank.class, rankInTopic.getPk(), rankInTopic);
	            //^QUESTION - Not sure why update() isn't currently working... 
	            //Until update() works I'll delete the old UserRank and create 
            	//  a new one with the updated rank
            beanService.deleteById(UserRank.class, oldUserRank.getPk());
            beanService.create(rankInTopic);
        }
        catch(HibernateException e) {
	        if (tx != null)
	            tx.rollback();
        }
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
    	
}
