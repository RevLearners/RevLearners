package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name=Constants.TABLE_REASON_TYPE)
public class ReasonType implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2405792134925676181L;

	@Id
	@Column(name=Constants.COLUMN_TYPE_ID)
	private long typeId;
	
	@Column(name=Constants.COLUMN_REASON_TYPE)
	private String type;

	public ReasonType(Long valueOf, String string) {
		typeId = valueOf;
		type = string;
	}

	public long getTypeId() {
		return typeId;
	}

	public void setTypeId(long typeId) {
		this.typeId = typeId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
