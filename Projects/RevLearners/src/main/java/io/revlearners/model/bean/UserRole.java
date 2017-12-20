package io.revlearners.model.bean;

import java.io.Serializable;
import io.revlearners.util.commons.configs.Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name=Constants.TABLE_USER_ROLE)
public class UserRole implements Serializable {

	private static final long serialVersionUID = 4523050103926297436L;

	@Id
	@Column(name=Constants.COLUMN_ROLE_ID)
	private Long id;

	@Column(name=Constants.COLUMN_ROLE_NAME)
	private String name;

	public UserRole() {
	}

    public UserRole(Long id) {
        this.id = id;
    }

    public UserRole(Long id, String name) {
        this.id = id;
        this.name = name;
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

}
