package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_CHALLENGE_ATTEMPT)
public class ChallengeAttempt implements Serializable {

	private static final long serialVersionUID = -460168171956593784L;

	@Id
	@Column(name=Constants.COLUMN_ATTEMPT_ID)
	@SequenceGenerator(sequenceName="CATT_SEQ", name="CATT_SEQ")
    @GeneratedValue(generator="CATT_SEQ", strategy=GenerationType.SEQUENCE)	
	private Long id;

	@Column(name=Constants.COLUMN_ATTEMPT_SCORE)
    private Float score;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_CHALLENGE_ID, referencedColumnName = Constants.COLUMN_CHALLENGE_ID)
	private Challenge challenge;

	@ManyToMany(targetEntity=QuestionOption.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_CHALLENGE_ATTEMPT_ANSWERS, joinColumns=@JoinColumn(name=Constants.COLUMN_ATTEMPT_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_OPTION_ID))
	private List<QuestionOption> answers;

	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name=Constants.COLUMN_USER_ID)
	private User user;

    public ChallengeAttempt() {
	}
	
	public ChallengeAttempt(Challenge challenge, User user, List<QuestionOption> answers, Float score) {
	    this.challenge = challenge;
		this.answers = answers;
		this.user = user;
		this.score = score;
	}

	public Challenge getChallenge() {
		return challenge;
	}

	public void setChallenge(Challenge challenge) {
		this.challenge = challenge;
	}

	public List<QuestionOption> getAnswers() {
		return answers;
	}

	public void setAnswers(List<QuestionOption> answers) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
