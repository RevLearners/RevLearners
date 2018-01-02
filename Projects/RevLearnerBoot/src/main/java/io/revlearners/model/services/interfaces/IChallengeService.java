package io.revlearners.model.services.interfaces;

import io.revlearners.model.bean.*;
import io.revlearners.model.bo.ChallengeInfoBo;

import java.util.List;

public interface IChallengeService {

    Challenge generateChallenge(ChallengeInfoBo info);

    List<Challenge> getChallengesByUser(long userId);

    Question saveQuestion(Question question);

    Challenge getChallengeById(long id);

    List<ChallengeAttempt> getChallengeAttemptsByUser(long challengeId, long userId);

    ChallengeAttempt submitChallengeAttempt(ChallengeAttempt attempt);

    ChallengeAttempt getAttemptById(Long id);
}
