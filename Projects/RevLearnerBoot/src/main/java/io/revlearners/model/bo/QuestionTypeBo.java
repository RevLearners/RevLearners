package io.revlearners.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

public class QuestionTypeBo {

	private Long id;
	private String name;
	private Float baseVal;

	public Float getBaseVal() {
		return baseVal;
	}

	public void setBaseVal(Float baseVal) {
		this.baseVal = baseVal;
	}

	public QuestionTypeBo(Long id, String name, Float baseVal) {
		this.id = id;
		this.name = name;
		this.baseVal = baseVal;
	}

    public QuestionTypeBo(Long id) {
        this.id = id;
    }

    public QuestionTypeBo() {
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
