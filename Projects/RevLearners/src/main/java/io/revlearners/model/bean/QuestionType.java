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
	private int qTypeId;
	
	@Column(name="QUESTION_TYPE_NAME")
	private int qTypeName;

	public QuestionType(int qTypeId, int qTypeName) {
		super();
		this.qTypeId = qTypeId;
		this.qTypeName = qTypeName;
	}
	
	public QuestionType() {

	}

	public int getqTypeId() {
		return qTypeId;
	}

	public void setqTypeId(int qTypeId) {
		this.qTypeId = qTypeId;
	}

	public int getqTypeName() {
		return qTypeName;
	}

	public void setqTypeName(int qTypeName) {
		this.qTypeName = qTypeName;
	}

	@Override
	public String toString() {
		return "QuestionType [qTypeId=" + qTypeId + ", qTypeName=" + qTypeName + "]";
	}
		
}
