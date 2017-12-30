package io.revlearners.model.bo;

import java.util.Set;

public class ChallengeAttemptBo2 {
	private Long id;
    private Long userId;
    private Float score;
	private ChallengeBo challenge;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public ChallengeBo getChallenge() {
        return challenge;
    }

    public void setChallenge(ChallengeBo challenge) {
        this.challenge = challenge;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Set<QuestionOptionBo2> getAnswers() {
        return answers;
    }

    public void setAnswers(Set<QuestionOptionBo2> answers) {
        this.answers = answers;
    }

    private Set<QuestionOptionBo2> answers;
}
