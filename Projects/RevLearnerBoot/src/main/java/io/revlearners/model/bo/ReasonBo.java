package io.revlearners.model.bo;

import java.io.Serializable;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import io.revlearners.util.commons.configs.Constants;

public class ReasonBo {

	private Long id;
	private String name;
	private ReasonTypeBo type;
	private String description;

	public ReasonBo() {
	}

    public ReasonBo(Long id) {
        this.id = id;
    }

    public ReasonBo(Long id, String name, String description, ReasonTypeBo type) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.description = description;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ReasonBo(String name) {
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

	public ReasonTypeBo getType() {
		return type;
	}

	public void setType(ReasonTypeBo type) {
		this.type = type;
	}
}
