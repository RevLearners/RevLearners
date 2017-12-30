package io.revlearners.model.bean;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name=Constants.TABLE_USER_STATUS)
public class UserStatus implements Serializable {

	private static final long serialVersionUID = 1582847082129648664L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Id
	@Column(name=Constants.COLUMN_STATUS_ID)
	private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Column(name=Constants.COLUMN_STATUS_NAME)
	private String name;

    public UserStatus(String name) {
        this.name = name;
    }

    public UserStatus(Long id) {
        this.id = id;
    }

    public UserStatus(Long id, String name) {
        this.id = id;
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
