package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table (name=Constants.TABLE_QUESTION_TYPE)
public class QuestionType implements Serializable{
	private static final long serialVersionUID = -2990237829521957808L;

	@Id
	@Column (name=Constants.COLUMN_QUESTION_TYPE_ID)
	@SequenceGenerator(sequenceName="QUESTION_TYPE_SEQ", name="QUESTION_TYPE_SEQ")
	@GeneratedValue(generator="QUESTION_TYPE_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name=Constants.COLUMN_QUESTION_TYPE_NAME)
	private String name;
	
	@Column(name=Constants.COLUMN_BASE_VALUE)
	private double baseVal;

	public double getBaseVal() {
		return baseVal;
	}

	public void setBaseVal(double baseVal) {
		this.baseVal = baseVal;
	}

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
