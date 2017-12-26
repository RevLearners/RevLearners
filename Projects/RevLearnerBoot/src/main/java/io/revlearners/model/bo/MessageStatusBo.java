package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

public class MessageStatusBo {

    private Long id;
    private String name;

    public MessageStatusBo() {
    }

    public MessageStatusBo(Long id, String string) {
		this.id = id;
		name = string;
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
