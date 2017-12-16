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
	@Column(name="Q_OPTION_ID")
	@SequenceGenerator(
			sequenceName="Q_OPTION_SEQ", 
			name="Q_OPTION_SEQ")
	@GeneratedValue(
			generator="Q_OPTION_SEQ", 
			strategy=GenerationType.SEQUENCE)
	private int qOptionId;
	
	@ManyToOne(
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_ID")
	private Question question;
	
	@Column(name="OPTION_TEXTS")
	private String optionTexts;

	@Column(name="IS_CORRECT")
	private boolean isCorrect;

	public QuestionOption(int qOptionId, Question question, String optionTexts, boolean isCorrect) {
		super();
		this.qOptionId = qOptionId;
		this.question = question;
		this.optionTexts = optionTexts;
		this.isCorrect = isCorrect;
	}
	
	public QuestionOption() {
		
	}
	
	public QuestionOption(Question question) {
		this.question = question;
	}

	public int getqOptionId() {
		return qOptionId;
	}

	public void setqOptionId(int qOptionId) {
		this.qOptionId = qOptionId;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public String getOptionTexts() {
		return optionTexts;
	}

	public void setOptionTexts(String optionTexts) {
		this.optionTexts = optionTexts;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "QuestionOption [qOptionId=" + qOptionId + ", question=" + question + ", optionTexts=" + optionTexts
				+ ", isCorrect=" + isCorrect + "]";
	}

}
