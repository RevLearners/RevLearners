package io.revlearners.model.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

@Entity
@Table (name=Constants.TABLE_QUIZ)
public class Quiz implements Serializable{
	private static final long serialVersionUID = 4858112442645949427L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Id
	@Column(name=Constants.COLUMN_QUIZ_ID)
	@SequenceGenerator(sequenceName="QUIZ_SEQ", name="QUIZ_SEQ")
    @GeneratedValue(generator="QUIZ_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Column(name=Constants.COLUMN_QUIZ_TIME)
	private LocalDateTime time;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@ManyToMany(cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_QUIZ_QUESTION, joinColumns=@JoinColumn(name=Constants.COLUMN_QUIZ_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_QUESTION_ID))
	private Set<Question> questions;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name=Constants.COLUMN_ATTEMPT_SCORE)
    private Float maxScore;

	public Quiz(Set<Question> questions, LocalDateTime time) {
		this.questions = questions;
		this.time = time;
	}

	public Quiz() {
	}

	public Quiz(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getTime() {
		return time;
	}

	public void setTime(LocalDateTime time) {
		this.time = time;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

    public Float getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(Float maxScore) {
        this.maxScore = maxScore;
    }

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", time=" + time + "]";
	}

}
