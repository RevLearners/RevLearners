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

@Entity
@Table (name="QUIZ")
public class Quiz implements Serializable{
	private static final long serialVersionUID = 4858112442645949427L;

	@Id
	@Column(name="QUIZ_ID")
	@SequenceGenerator(
			sequenceName="QUIZ_SEQ", 
			name="QUIZ_SEQ")
	@GeneratedValue(
			generator="QUIZ_SEQ", 
			strategy=GenerationType.SEQUENCE)
	private int quizId;
	
	@ManyToOne(
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="TO_USER_ID")
	private User toUser;
	
	@ManyToOne(
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="FROM_USER_ID")
	private User fromUser;
	
	@Column(name="QUIZ_TIME")
	private Date time;
	
	@ManyToMany(
			targetEntity=Question.class,
			cascade=CascadeType.ALL,
			fetch=FetchType.EAGER)
	@JoinTable(
			name="QUIZ_QUESTION",
			joinColumns=@JoinColumn(name="BEAR_ID"), 
			inverseJoinColumns=@JoinColumn(name="CUB_ID"))
	private Set<Question> questions;

	public Quiz(int quizId, User toUser, User fromUser, Date time) {
		super();
		this.quizId = quizId;
		this.toUser = toUser;
		this.fromUser = fromUser;
		this.time = time;
	}
	
	public Quiz() {

	}
	
	public Quiz(int quizId) {
		this.quizId = quizId;
	}

	public int getQuizId() {
		return quizId;
	}

	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
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
		return "Quiz [quizId=" + quizId + ", toUser=" + toUser + ", fromUser=" + fromUser + ", time=" + time + "]";
	}	
	
}
