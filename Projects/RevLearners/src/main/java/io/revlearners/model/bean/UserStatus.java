package io.revlearners.model.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_STATUS")
public class UserStatus implements Serializable {

	private static final long serialVersionUID = 1582847082129648664L;

	@Id
	@Column(name="US_STAT_ID")
	private int statusId;
	
	@Column(name="US_STAT")
	private String status;

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
