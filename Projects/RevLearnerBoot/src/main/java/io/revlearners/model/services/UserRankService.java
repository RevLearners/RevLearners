package io.revlearners.model.services;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.dao.interfaces.IUserRankRepository;
import io.revlearners.model.dao.interfaces.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.UserRank;
import io.revlearners.model.services.interfaces.IUserRankService;

import java.util.Optional;

@Service
public class UserRankService extends CrudService<UserRank> implements IUserRankService {

    @Autowired
    IUserRankRepository userRankRepo;

    @Autowired
    IUserRepository userRepo;

    /**
     * assumes user is a managed entity, and thus all the accesses will
     * not throw LazyInitializationException
     *
     * @param increment
     * @param topic
     * @param user
     */
    private void applyMeritPoints(Float increment, Topic topic, User user) {
        UserRank rankInTopic = getUserRankForTopic(user, topic);
        rankInTopic.setMerit(rankInTopic.getMerit() + increment);
        float overflow = rankInTopic.getMerit() - rankInTopic.getRank().getMeritThreshold();

        // advance to user to next rank if merit rank exceeds threshold
        if (overflow > 0) {
            Rank nextRankInTopic = getNextUserRank(user, topic);
            UserRank nextUserRank = new UserRank(user, nextRankInTopic, overflow);
            user.getRanks().remove(rankInTopic);
            user.getRanks().add(nextUserRank);
            userRepo.save(user);    // update the ranks
        }
    }

    /**
     * assumes user is a managed entity, and thus all the accesses will
     * not throw LazyInitializationException
     *
     * @param user
     * @param topic
     * @return
     */
    private UserRank getUserRankForTopic(User user, Topic topic) {
        for (UserRank userRank : user.getRanks()) {
            if (userRank.getRank().getTopic().getId().equals(topic.getId()))
                return userRank;
        }
        return null;
    }

    /**
     * Assumes Topics is a managed entity
     *
     * Assumes user is a managed entity, and thus all the accesses will
     * not throw LazyInitializationException
     *
     * @param user
     * @param topic
     * @return
     */
    private Rank getNextUserRank(User user, Topic topic) {
        Rank currRank = getUserRankForTopic(user, topic).getRank();

        // get max rank for topic
        Optional<Rank> potMax = topic.getRanks().stream().max((a, b) -> (int)(a.getRelativeWeight() - b.getRelativeWeight()));
        if (!potMax.isPresent())
            return null;
        Rank maxRank = potMax.get();
        // if we're already at max rank don't bother
        if (currRank.getRelativeWeight() >= maxRank.getRelativeWeight() - 1)    // assumed that it cannot be greater of less than this
            return maxRank;

        long nextRelWeight = currRank.getRelativeWeight() + 1;
        for (Rank rank : topic.getRanks()) {
            if (rank.getRelativeWeight().equals(nextRelWeight))
                return rank;
        }
        return null;
    }

}
