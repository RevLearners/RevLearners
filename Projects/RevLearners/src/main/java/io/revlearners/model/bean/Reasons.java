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
@Table(name = "REASONS")
public class Reasons implements Serializable{

	@Id
	@Column (name="REASON_ID")
	@SequenceGenerator(sequenceName="REASON_SEQ", name="REASON_SEQ")
	@GeneratedValue(generator="REASON_SEQ", strategy=GenerationType.SEQUENCE)
	private int reasonId;
	
	@Column(name="name")
	private String name;

	public Reasons() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reasons(int reasonId, String name) {
		super();
		this.reasonId = reasonId;
		this.name = name;
	}

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
