package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_CHALLENGE_ATTEMPT)
public class ChallengeAttempt implements Serializable {

	private static final long serialVersionUID = -460168171956593784L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Id
	@Column(name=Constants.COLUMN_ATTEMPT_ID)
	@SequenceGenerator(sequenceName="CATT_SEQ", name="CATT_SEQ")
    @GeneratedValue(generator="CATT_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Column(name=Constants.COLUMN_ATTEMPT_SCORE)
    private Float score;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_CHALLENGE_ID)
	private Challenge challenge;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@ManyToOne(targetEntity=User.class, fetch=FetchType.EAGER)
	@JoinColumn(name=Constants.COLUMN_USER_ID)
	private User user;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@ManyToMany(targetEntity=QuestionOption.class, fetch=FetchType.EAGER)
	@JoinTable( name=Constants.TABLE_CHALLENGE_ATTEMPT_ANSWERS,
            joinColumns=@JoinColumn(updatable=false, name=Constants.COLUMN_ATTEMPT_ID),
            inverseJoinColumns=@JoinColumn(updatable=false, name=Constants.COLUMN_OPTION_ID))
	private Set<QuestionOption> answers;

    public ChallengeAttempt() {
	}

	public ChallengeAttempt(Challenge challenge, User user, Set<QuestionOption> answers, Float score) {
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

	public Set<QuestionOption> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<QuestionOption> answers) {
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
