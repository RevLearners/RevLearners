package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="QUESTION_DIFFICULTY")
public class QuestionDifficulty implements Serializable{
	private static final long serialVersionUID = -8771743210310047839L;
	
	@Id
	@Column (name="DIFFICULTY_ID")
	@SequenceGenerator(sequenceName="DIFFICULTY_SEQ", name="DIFFICULTY_SEQ")
	@GeneratedValue(generator="DIFFICULTY_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;

	@Column(name="DIFFICULTY_NAME")
	private String name;

	public QuestionDifficulty(String name) {
		this.name = name;
	}
	
	public QuestionDifficulty() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "QuestionDifficulty [id=" + id + ", name=" + name + "]";
	}

}
