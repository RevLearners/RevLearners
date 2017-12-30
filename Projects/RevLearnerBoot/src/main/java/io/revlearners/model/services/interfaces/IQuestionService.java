package io.revlearners.model.services.interfaces;

import io.revlearners.model.bean.*;
import io.revlearners.model.services.QuestionService;

import java.util.List;

public interface IQuestionService {

    float scoreChallenge(ChallengeAttempt attempt);

    Challenge generateChallenge(QuestionService.ChallengeInfo info);

    List<Challenge> getChallengesByUser(long userId);

    Question saveQuestion(Question question);

    Challenge getChallengeById(long id);

    List<ChallengeAttempt> getChallengeAttemptsByUser(long challengeId, long userId);
}
