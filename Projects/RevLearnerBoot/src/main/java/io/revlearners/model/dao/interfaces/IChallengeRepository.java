package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.User;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface IChallengeRepository extends IBaseRepository<Challenge> {
    Set<Challenge> getByUsersContains(User u);
}
