package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table (name=Constants.TABLE_QUESTION_DIFFICULTY)
public class QuestionDifficulty implements Serializable {

	private static final long serialVersionUID = -8771743210310047839L;

	@Id
	@Column (name=Constants.COLUMN_DIFFICULTY_ID)
	private Long id;

	@Column(name=Constants.COLUMN_DIFFICULTY_NAME)
	private String name;
	
	@Column(name=Constants.COLUMN_MULTIPLIER)
	private Float multiplier;

    public QuestionDifficulty(Long id, String name, Float multiplier) {
        this.id = id;
        this.name = name;
        this.multiplier = multiplier;
    }

    public QuestionDifficulty(Long id) {
        this.id = id;
    }

	public QuestionDifficulty() {
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
