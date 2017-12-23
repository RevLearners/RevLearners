package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_QUIZ_ATTEMPT)
public class QuizAttempt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -460168171956593784L;

	@Id
	@Column(name=Constants.COLUMN_ATTEMPT_ID)
	@SequenceGenerator(sequenceName="QATT_SEQ", name="QATT_SEQ")
    @GeneratedValue(generator="QATT_SEQ", strategy=GenerationType.SEQUENCE)	
	private Long id;
    
	@ManyToMany(targetEntity=QuestionOption.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_QUIZ_ATTEMPT_ANSWERS, joinColumns=@JoinColumn(name=Constants.COLUMN_ATTEMPT_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_OPTION_ID))
	private Set<QuestionOption> answers;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_USER_ID)
	private User user;
	
	public QuizAttempt() {
		
	}
	
	public QuizAttempt(User user, Set<QuestionOption> answers) {	
		this.user = user;
		this.answers = answers;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<QuestionOption> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<QuestionOption> answers) {
		this.answers = answers;
	}
}
