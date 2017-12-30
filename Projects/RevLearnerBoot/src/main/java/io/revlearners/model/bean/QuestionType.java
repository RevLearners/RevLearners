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
@Table (name=Constants.TABLE_QUESTION_TYPE)
public class QuestionType implements Serializable{
	private static final long serialVersionUID = -2990237829521957808L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Id
	@Column (name=Constants.COLUMN_QUESTION_TYPE_ID)
	private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Column(name=Constants.COLUMN_QUESTION_TYPE_NAME)
	private String name;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Column(name=Constants.COLUMN_BASE_VALUE)
	private Float baseVal;

	public Float getBaseVal() {
		return baseVal;
	}

	public void setBaseVal(Float baseVal) {
		this.baseVal = baseVal;
	}

	public QuestionType(Long id, String name, Float baseVal) {
		this.id = id;
		this.name = name;
		this.baseVal = baseVal;
	}

    public QuestionType(Long id) {
        this.id = id;
    }

    public QuestionType() {
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

	@Override
	public String toString() {
		return "QuestionType [id=" + id + ", name=" + name + "]";
	}

}
