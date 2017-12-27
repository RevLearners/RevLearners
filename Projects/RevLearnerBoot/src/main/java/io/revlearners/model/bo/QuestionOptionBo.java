package io.revlearners.model.bo;

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

import io.revlearners.util.commons.configs.Constants;

public class QuestionOptionBo {

	private Long id;
	private String text;
	private QuestionBo question;
	private boolean isCorrect;

	public QuestionOptionBo(QuestionBo question, String text, boolean isCorrect) {
		this.question = question;
		this.text = text;
		this.isCorrect = isCorrect;
	}

	public QuestionOptionBo() {
	}

//	public QuestionOption(Question question) {
//		this.question = question;
//	}

	public QuestionOptionBo(String string, boolean b) {
		this.text = string;
		this.isCorrect = b;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public QuestionBo getQuestion() {
		return question;
	}

	public void setQuestion(QuestionBo question) {
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
		return "QuestionOption [id=" + id + ", text=" + text
				+ ", isCorrect=" + isCorrect + "]";
	}

}
