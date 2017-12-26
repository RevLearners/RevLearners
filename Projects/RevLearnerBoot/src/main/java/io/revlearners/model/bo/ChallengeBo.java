package io.revlearners.model.bo;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

public class ChallengeBo {

	private Long id;
	
	private QuizBo quiz;

	private Set<UserBo> users;
	
	private Set<ChallengeAttemptBo> attempts;

	public ChallengeBo() {
		
	}
	
	public ChallengeBo(QuizBo quiz, Set<UserBo> users) {
		this.quiz = quiz;
        this.users = users;
    }
	
	public ChallengeBo(Long id2, QuizBo map, Set<ChallengeAttemptBo> attempts2, Set<UserBo> users2) {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuizBo getQuiz() {
		return quiz;
	}

	public void setQuiz(QuizBo quiz) {
		this.quiz = quiz;
	}

	public Set<ChallengeAttemptBo> getAttempts() {
		return attempts;
	}

	public void setAttempts(Set<ChallengeAttemptBo> attempts) {
		this.attempts = attempts;
	}

    public Set<UserBo> getUsers() {
        return users;
    }

    public void setUsers(Set<UserBo> users) {
        this.users = users;
    }

}
