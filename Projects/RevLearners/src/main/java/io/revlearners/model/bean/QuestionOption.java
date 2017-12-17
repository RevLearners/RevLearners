package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="QUESTION_OPTION")
public class QuestionOption implements Serializable{
	private static final long serialVersionUID = 8295215015097184041L;
	
	@Id
	@Column(name="OPTION_ID")
	@SequenceGenerator(sequenceName="Q_OPTION_SEQ", name="Q_OPTION_SEQ")
	@GeneratedValue(generator="Q_OPTION_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@Column(name="OPTION_TEXTS")
	private String text;

	@Column(name="IS_CORRECT")
	private boolean isCorrect;

	public QuestionOption(Question question, String text, boolean isCorrect) {
		this.question = question;
		this.text = text;
		this.isCorrect = isCorrect;
	}
	
	public QuestionOption() {
	}
	
	public QuestionOption(Question question) {
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "QuestionOption [id=" + id + ", question=" + question + ", text=" + text
				+ ", isCorrect=" + isCorrect + "]";
	}

}
