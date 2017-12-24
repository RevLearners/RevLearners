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
@Table(name = Constants.TABLE_QUIZ_ATTEMPT)
public class QuizAttempt implements Serializable {

	private static final long serialVersionUID = -460168171956593784L;

	@Id
	@Column(name=Constants.COLUMN_ATTEMPT_ID)
	@SequenceGenerator(sequenceName="QATT_SEQ", name="QATT_SEQ")
    @GeneratedValue(generator="QATT_SEQ", strategy=GenerationType.SEQUENCE)	
	private Long id;

	@Column(name=Constants.COLUMN_ATTEMPT_SCORE)
    private Float score;
    
	@ManyToMany(targetEntity=QuestionOption.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_QUIZ_ATTEMPT_ANSWERS, joinColumns=@JoinColumn(name=Constants.COLUMN_ATTEMPT_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_OPTION_ID))
	private List<QuestionOption> answers;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_USER_ID)
	private User user;

    @ManyToOne
    @JoinColumn(name = Constants.COLUMN_QUIZ_ID)
    private Quiz quiz;
	
	public QuizAttempt() {
		
	}
	
	public QuizAttempt(Quiz quiz, User user, List<QuestionOption> answers, Float score) {
		this.user = user;
		this.answers = answers;
		this.quiz = quiz;
		this.score = score;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<QuestionOption> getAnswers() {
		return answers;
	}

	public void setAnswers(List<QuestionOption> answers) {
		this.answers = answers;
	}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }
}
