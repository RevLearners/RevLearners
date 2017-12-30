package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Set;

@Repository
public interface IChallengeRepository extends JpaRepository<Challenge, Serializable> {
    Set<Challenge> getByUsersContaining(User user);
}
