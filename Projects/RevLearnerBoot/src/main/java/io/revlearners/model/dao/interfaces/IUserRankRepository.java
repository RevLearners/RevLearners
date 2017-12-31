package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRank;
import org.springframework.stereotype.Repository;

public interface IUserRankRepository extends IBaseRepository<UserRank> {

    /*
    UserRank getByUserAndRank(User user, Rank rank);

    UserRank findByUserAndRank(User user, Rank rank);
    */
}
