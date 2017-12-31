package io.revlearners.model.services;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.dao.interfaces.IUserRankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.UserRank;
import io.revlearners.model.services.interfaces.IUserRankService;

import java.util.Set;

@Service
public class UserRankService extends CrudService<UserRank> implements IUserRankService {

    @Autowired
    IUserRankRepository repo;

    private void applyMeritPoints(Float increment, Topic topic, User user) {
        Set<UserRank> userRanks = user.getRanks();

    }

    private UserRank getRankForTopic(User user, Topic topic) {
        for (UserRank userRank : user.getRanks()) {
            if (userRank.getRank().getTopic().getId().equals(topic.getId()))
                return userRank;
        }
        return null;
    }

    private UserRank getNextRank(User user, Topic topic) {
        for (UserRank userRank : user.getRanks()) {
            if (userRank.getRank().getTopic().getId().equals(topic.getId()))
                return userRank;
        }
        return null;
    }

}
