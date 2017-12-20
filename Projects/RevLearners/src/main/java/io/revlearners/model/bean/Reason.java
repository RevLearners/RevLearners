package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_REASON)
public class Reason implements Serializable {

	private static final long serialVersionUID = -3010188115386046059L;

	@Id
	@Column (name=Constants.COLUMN_REASON_ID)
	private Long id;

	@Column(name=Constants.COLUMN_REASON)
	private String name;

	@ManyToOne
    @JoinColumn(name=Constants.COLUMN_TYPE_ID)
	private ReasonType type;

	@Column(name=Constants.COLUMN_DESCRIPTION)
	private String description;

	public Reason() {
	}

    public Reason(Long id) {
        this.id = id;
    }

    public Reason(Long id, String name, String description, ReasonType type) {
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

	public Reason(String name) {
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

	public ReasonType getType() {
		return type;
	}

	public void setType(ReasonType type) {
		this.type = type;
	}
}
