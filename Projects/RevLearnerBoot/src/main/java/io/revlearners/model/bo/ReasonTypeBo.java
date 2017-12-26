package io.revlearners.model.bo;

import java.io.Serializable;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

public class ReasonTypeBo {

	private long id;
	private String type;
	
	public ReasonTypeBo(Long id, String string) {
		this.id = id;
		type = string;
	}

	public ReasonTypeBo() {
		
	}
	
	public ReasonTypeBo(long id) {
        this.id = id;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
