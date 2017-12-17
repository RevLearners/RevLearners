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
@Table(name = "REASON")
public class Reason implements Serializable {

	@Id
	@Column (name="REASON_ID")
	@SequenceGenerator(sequenceName="REASON_SEQ", name="REASON_SEQ")
	@GeneratedValue(generator="REASON_SEQ", strategy=GenerationType.SEQUENCE)
	private Long reasonId;
	
	@Column(name="NAME")
	private String name;

	public Reason() {
	}

	public Reason(String name) {
		this.name = name;
	}

	public Long getReasonId() {
		return reasonId;
	}

	public void setReasonId(Long reasonId) {
		this.reasonId = reasonId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
