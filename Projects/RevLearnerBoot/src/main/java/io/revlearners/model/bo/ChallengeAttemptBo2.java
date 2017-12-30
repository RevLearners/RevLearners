package io.revlearners.model.bo;

import java.util.List;
import java.util.Map;

public class ChallengeAttemptBo2 {
    private Long userId;
    private Long challengeId;
	private Map<Long, List<Long>> answers;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChallengeId() {
        return challengeId;
    }

    public void setChallengeId(Long challengeId) {
        this.challengeId = challengeId;
    }

    public Map<Long, List<Long>> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<Long, List<Long>> answers) {
        this.answers = answers;
    }
}
