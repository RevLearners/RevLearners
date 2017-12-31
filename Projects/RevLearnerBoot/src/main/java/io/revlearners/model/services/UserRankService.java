package io.revlearners.model.services;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.services.interfaces.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.UserRank;
import io.revlearners.model.services.interfaces.IUserRankService;

@Service
public class UserRankService extends CrudService<UserRank> implements IUserRankService {

    @Autowired
    IUserRankService userRanksService;

    private void applyMeritPoints(Float increment, Topic topic, User user) {
        // userRanksService;
    }
}
