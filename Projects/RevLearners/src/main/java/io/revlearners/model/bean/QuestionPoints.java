package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="QUESTION_POINTS")
public class QuestionPoints implements Serializable{
	private static final long serialVersionUID = -2384622168604669536L;
	
	@Id
	@Column(name="Q_POINTS_ID")
	@SequenceGenerator(
			sequenceName="Q_POINTS_SEQ", 
			name="Q_POINTS_SEQ")
	@GeneratedValue(
			generator="Q_POINTS_SEQ", 
			strategy=GenerationType.SEQUENCE)
	private int qPointsId;
	
	@ManyToOne(
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="QUESTION_TYPE_ID")
	private QuestionType questionType;
	
	@ManyToOne(
			cascade=CascadeType.ALL, 
			fetch=FetchType.EAGER)
	@JoinColumn(name="DIFFICULTY_ID")
	private QuestionDifficulty questionDifficulty;
	
	@Column(name="QUESTION_POINTS")
	private int points;

	public QuestionPoints(int qPointsId, QuestionType questionType, QuestionDifficulty questionDifficulty, int points) {
		super();
		this.qPointsId = qPointsId;
		this.questionType = questionType;
		this.questionDifficulty = questionDifficulty;
		this.points = points;
	}

	public QuestionPoints() {
		
	}

	public int getqPointsId() {
		return qPointsId;
	}

	public void setqPointsId(int qPointsId) {
		this.qPointsId = qPointsId;
	}

	public QuestionType getQuestionType() {
		return questionType;
	}

	public void setQuestionType(QuestionType questionType) {
		this.questionType = questionType;
	}

	public QuestionDifficulty getQuestionDifficulty() {
		return questionDifficulty;
	}

	public void setQuestionDifficulty(QuestionDifficulty questionDifficulty) {
		this.questionDifficulty = questionDifficulty;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "QuestionPoints [qPointsId=" + qPointsId + ", questionType=" + questionType + ", questionDifficulty="
				+ questionDifficulty + ", points=" + points + "]";
	}
	
}
