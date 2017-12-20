package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name=Constants.TABLE_MESSAGE_STATUS)
public class MessageStatus implements Serializable {

	private static final long serialVersionUID = -7382897656952549192L;

	@Id
    @Column(name = Constants.COLUMN_STATUS_ID)
    private Long id;

    @Column(name = Constants.COLUMN_MESSAGE_STATUS_NAME)
    private String name;

    public MessageStatus() {
    }

    public MessageStatus(Long id, String string) {
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
