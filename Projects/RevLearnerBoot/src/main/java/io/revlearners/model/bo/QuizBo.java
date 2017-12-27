package io.revlearners.model.bo;

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

import io.revlearners.util.commons.configs.Constants;
import org.hibernate.annotations.Fetch;

public class QuizBo {

	private Long id;	
	private LocalDateTime time;
	private Set<QuestionBo> questions;

	public QuizBo(Set<QuestionBo> questions, LocalDateTime time) {
		this.questions = questions;
		this.time = time;
	}

	public QuizBo() {
	}

	public QuizBo(Long id) {
		this.id = id;
	}

	public QuizBo(Long id2, LocalDateTime time2, Set<QuestionBo> questions2) {
		// TODO Auto-generated constructor stub
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

	public Set<QuestionBo> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<QuestionBo> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Quiz [id=" + id + ", time=" + time + "]";
	}

}
