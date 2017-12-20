package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name = Constants.TABLE_MIME_TYPE)
public class MimeType implements Serializable {

	private static final long serialVersionUID = -2378392009368245684L;

	@Id
	@Column(name = Constants.COLUMN_MIME_ID)
	private Long id;

	@Column(name = Constants.COLUMN_MIME_NAME)
	private String name;

	public MimeType() {
	}

	public MimeType(Long id, String name) {
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
