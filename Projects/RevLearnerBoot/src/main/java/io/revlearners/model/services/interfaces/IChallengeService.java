package io.revlearners.model.services.interfaces;

import io.revlearners.model.bean.*;
import io.revlearners.model.services.ChallengeService;

import java.util.List;

public interface IChallengeService {

    float submitChallengeAttempt(ChallengeAttempt attempt);

    Challenge generateChallenge(ChallengeService.ChallengeInfo info);

    List<Challenge> getChallengesByUser(long userId);

    Question saveQuestion(Question question);

    Challenge getChallengeById(long id);

    List<ChallengeAttempt> getChallengeAttemptsByUser(long challengeId, long userId);
}
