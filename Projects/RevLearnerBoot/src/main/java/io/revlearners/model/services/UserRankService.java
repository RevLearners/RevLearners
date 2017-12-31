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
import java.util.Set;

@Service
public class UserRankService extends CrudService<UserRank> implements IUserRankService {

    @Autowired
    IUserRankRepository userRankRepo;

    /**
     * assumes user is a managed entity, and thus all the accesses will
     * not throw LazyInitializationException
     *
     * @param increment
     * @param topic
     * @param user
     */
    private void applyMeritPoints(Float increment, Topic topic, User user) {
        Set<UserRank> userRanks = user.getRanks();

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
    /*
    private Rank getNextUserRank(User user, Topic topic) {
        Optional<Rank> potMax = topic.getRanks().stream().max((a, b) -> (int)(a.getRelativeWeight() - b.getRelativeWeight()));
        if (!potMax.isPresent())
            return null;

        Rank maxRank = potMax.get();
        Rank currRank = getUserRankForTopic(user, topic).getRank();

        if (currRank.getRank().getRelativeWeight() >= maxRank.getRelativeWeight() - 1)    // assumed that it cannot be greater of less than
            return maxRank;

        for (Rank rank : topic.getRanks()) {
            if (rank.getTopic().getId().equals(topic.getId()) && rank.getRelativeWeight().equals(currRank.getRank().getRelativeWeight() + 1));
                return rank;
        }
        return null;
    }

    private Rank getMaxRankForTopic(Topic topic) {
        return potMax.orElse(null);
    }
    */

}
