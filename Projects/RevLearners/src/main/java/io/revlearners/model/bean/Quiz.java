package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table (name=Constants.TABLE_QUIZ)
public class Quiz implements Serializable{
	private static final long serialVersionUID = 4858112442645949427L;

	@Id
	@Column(name=Constants.COLUMN_QUIZ_ID)
	@SequenceGenerator(sequenceName="QUIZ_SEQ", name="QUIZ_SEQ")
    @GeneratedValue(generator="QUIZ_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne( cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name=Constants.COLUMN_USER_RECEIVER)
	private User receiver;

	@ManyToOne( cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    @JoinColumn(name=Constants.COLUMN_USER_SENDER)
	private User sender;

	@Column(name=Constants.COLUMN_QUIZ_TIME)
	private Date time;

	@ManyToMany(targetEntity=Question.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_QUIZ_QUESTION, joinColumns=@JoinColumn(name=Constants.COLUMN_QUIZ_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_QUESTION_ID))
	private Set<Question> questions;

	public Quiz(Long id, User receiver, User sender, Date time) {
		super();
		this.id = id;
		this.receiver = receiver;
		this.sender = sender;
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

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Set<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<Question> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", receiver=" + receiver + ", sender=" + sender + ", time=" + time + "]";
	}

}
