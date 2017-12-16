package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="QUESTION_DIFFICULTY")
public class QuestionDifficulty implements Serializable{
	private static final long serialVersionUID = -8771743210310047839L;
	
	@Id
	@Column (name="DIFFICULTY_ID")
	@SequenceGenerator(sequenceName="DIFFICULTY_SEQ", name="DIFFICULTY_SEQ")
	@GeneratedValue(generator="DIFFICULTY_SEQ", strategy=GenerationType.SEQUENCE)
	private int difficultyId;
	
	@Column(name="DIFFICULTY_NAME")
	private int difficultyName;

	public QuestionDifficulty(int difficultyId, int difficultyName) {
		super();
		this.difficultyId = difficultyId;
		this.difficultyName = difficultyName;
	}
	
	public QuestionDifficulty() {
		
	}

	public int getDifficultyId() {
		return difficultyId;
	}

	public void setDifficultyId(int difficultyId) {
		this.difficultyId = difficultyId;
	}

	public int getDifficultyName() {
		return difficultyName;
	}

	public void setDifficultyName(int difficultyName) {
		this.difficultyName = difficultyName;
	}

	@Override
	public String toString() {
		return "QuestionDifficulty [difficultyId=" + difficultyId + ", difficultyName=" + difficultyName + "]";
	}

}
