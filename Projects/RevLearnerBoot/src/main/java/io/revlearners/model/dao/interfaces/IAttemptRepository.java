package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Set;

@Repository
public interface IAttemptRepository extends JpaRepository<ChallengeAttempt, Serializable> {
    /**
     * Given a user and a challenge, fetch the attempts user has made on the challenge
     *
     * Like most of the other DAO/Repository classes, you will notice that there is
     * no implementing class for this interface. That is because spring auto-magically
     * derives provides the implementation from the method name and signature
     *
     * Auto complete is helpful to figure out naming convention and possibilities
     *
     * @param user
     * @param challenge
     * @return
     */
    Set<ChallengeAttempt> getByUserAndChallenge(User user, Challenge challenge);
}
