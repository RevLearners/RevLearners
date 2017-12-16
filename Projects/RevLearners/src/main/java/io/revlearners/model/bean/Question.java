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
@Table (name="QUESTION")
public class Question implements Serializable{
	private static final long serialVersionUID = 3506791910251447189L;

	@Id
	@Column(name="QUESTION_ID")
	@SequenceGenerator(
			sequenceName="QUESTION_SEQ", 
			name="QUESTION_SEQ")
	@GeneratedValue(
			generator="QUESTION_SEQ", 
			strategy=GenerationType.SEQUENCE)
	private int questionId;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_LANGUAGE")
	private Language language;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_TYPE")
	private QuestionType questionType;

	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_DIFFICULTY")
	private QuestionDifficulty questionDifficulty;
	
	@Column(name="Q_TEXTS")
	private String qTexts;

	public Question(int questionId, Language language, QuestionType questionType, QuestionDifficulty questionDifficulty,
			String qTexts) {
		super();
		this.questionId = questionId;
		this.language = language;
		this.questionType = questionType;
		this.questionDifficulty = questionDifficulty;
		this.qTexts = qTexts;
	}
	
	public Question() {

	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionDifficulty getQuestionDifficulty() {
		return questionDifficulty;
	}

	public void setQuestionDifficulty(QuestionDifficulty questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}

	public String getqTexts() {
		return qTexts;
	}

	public void setqTexts(String qTexts) {
		this.qTexts = qTexts;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", language=" + language + ", questionType=" + questionType
				+ ", questionDifficulty=" + questionDifficulty + ", qTexts=" + qTexts + "]";
	}

}
