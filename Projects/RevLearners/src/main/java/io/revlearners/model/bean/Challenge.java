package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_CHALLENGE)
public class Challenge implements Serializable {
	
	private static final long serialVersionUID = -7617567946904028684L;

	@Id
	@Column(name=Constants.COLUMN_CHALLENGE_ID)
	@SequenceGenerator(sequenceName="CHAL_SEQ", name="CHAL_SEQ")
    @GeneratedValue(generator="CHAL_SEQ", strategy=GenerationType.SEQUENCE)	
	private Long id;
	
	@OneToOne
    @JoinColumn(name=Constants.COLUMN_QUIZ_ID)
	private Quiz quiz;

    @ManyToMany
    @JoinTable(name=Constants.COLUMN_CHALLENGE_USERS, joinColumns=@JoinColumn(name=Constants.COLUMN_CHALLENGE_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_USER_ID))
	private Set<User> users;
	
	@OneToMany(mappedBy="challenge", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ChallengeAttempt> attempts;

	public Challenge() {
		
	}
	
	public Challenge(Quiz quiz, Set<User> users) {
		this.quiz = quiz;
        this.users = users;
    }
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Quiz getQuiz() {
		return quiz;
	}

	public void setQuiz(Quiz quiz) {
		this.quiz = quiz;
	}

	public Set<ChallengeAttempt> getAttempts() {
		return attempts;
	}

	public void setAttempts(Set<ChallengeAttempt> attempts) {
		this.attempts = attempts;
	}

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

}
