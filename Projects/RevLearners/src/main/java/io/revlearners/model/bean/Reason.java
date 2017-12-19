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
@Table(name = Constants.TABLE_REASON)
public class Reason implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3010188115386046059L;

	@Id
	@Column (name=Constants.COLUMN_REASON_ID)
	@SequenceGenerator(sequenceName="REASON_SEQ", name="REASON_SEQ")
	@GeneratedValue(generator="REASON_SEQ", strategy=GenerationType.SEQUENCE)
	private Long reasonId;
	
	@Column(name=Constants.COLUMN_REASON)
	private String name;
	
	@Column(name=Constants.COLUMN_TYPE_ID)
	private int type;
	
	@Column(name=Constants.COLUMN_DESCRIPTION)
	private String description;

	public Reason() {
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	public int getType() {
		return type;
	}
	
	public void setType(int type) {
		this.type = type;
	}
}
