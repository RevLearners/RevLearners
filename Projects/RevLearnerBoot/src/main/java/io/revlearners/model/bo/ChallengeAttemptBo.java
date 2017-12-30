package io.revlearners.model.bo;

import java.util.Set;

public class ChallengeAttemptBo {

	private Long id;
    private Float score;
	private ChallengeBo challenge;
	private UserBo user;
	private Set<QuestionOptionBo> answers;

    public ChallengeAttemptBo() {
	}

	public ChallengeAttemptBo(ChallengeBo challenge, UserBo user, Set<QuestionOptionBo> answers, Float score) {
	    this.challenge = challenge;
		this.answers = answers;
		this.user = user;
		this.score = score;
	}

	public ChallengeAttemptBo(Long id, UserBo user, Set<QuestionOptionBo> answers) {
		this.id = id;
		this.user = user;
		this.answers = answers;
	}

	public ChallengeBo getChallenge() {
		return challenge;
	}

	public void setChallenge(ChallengeBo challenge) {
		this.challenge = challenge;
	}

	public Set<QuestionOptionBo> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<QuestionOptionBo> answers) {
		this.answers = answers;
	}

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

    public UserBo getUser() {
        return user;
    }

    public void setUser(UserBo user) {
        this.user = user;
    }
}
