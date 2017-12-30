package io.revlearners.model.bo;

import java.util.List;

public class ChallengeAttemptBo2 {
    private Long userId;
    private Long challengeId;
    private Float score;
	private List<Long> answers;


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

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public List<Long> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Long> answers) {
        this.answers = answers;
    }
}
