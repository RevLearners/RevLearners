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
	@Column(name="STATUS_ID")
	private Long id;
	
	@Column(name="STATUS_NAME")
	private String name;

    public UserStatus(String name) {
        this.name = name;
    }

    public UserStatus() {}

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
}
