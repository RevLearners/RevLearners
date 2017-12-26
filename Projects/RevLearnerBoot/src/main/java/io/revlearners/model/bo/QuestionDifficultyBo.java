package io.revlearners.model.bo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

public class QuestionDifficultyBo {
	private Long id;
	private String name;
	private Float multiplier;

    public QuestionDifficultyBo(Long id, String name, Float multiplier) {
        this.id = id;
        this.name = name;
        this.multiplier = multiplier;
    }

    public QuestionDifficultyBo(Long id) {
        this.id = id;
    }

	public QuestionDifficultyBo() {
	}

    public Float getMultiplier() {
		return multiplier;
	}

	public void setMultiplier(Float multiplier) {
		this.multiplier = multiplier;
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
		return "QuestionDifficulty [id=" + id + ", name=" + name + "]";
	}

}
