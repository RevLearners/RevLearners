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
@Table (name="QUESTION_TYPE")
public class QuestionType implements Serializable{
	private static final long serialVersionUID = -2990237829521957808L;

	@Id
	@Column (name="QUESTION_TYPE_ID")
	@SequenceGenerator(sequenceName="QUESTION_TYPE_SEQ", name="QUESTION_TYPE_SEQ")
	@GeneratedValue(generator="QUESTION_TYPE_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="QUESTION_TYPE_NAME")
	private String name;

	public QuestionType(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	
	public QuestionType() {

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
		return "QuestionType [id=" + id + ", name=" + name + "]";
	}
		
}
