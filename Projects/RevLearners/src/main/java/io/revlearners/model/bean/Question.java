package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_QUESTION)
public class Question implements Serializable {
	private static final long serialVersionUID = 3506791910251447189L;

	@Id
	@Column(name = Constants.COLUMN_QUESTION_ID)
	@SequenceGenerator(sequenceName = "QUESTION_SEQ", name = "QUESTION_SEQ")
	@GeneratedValue(generator = "QUESTION_SEQ", strategy = GenerationType.SEQUENCE)
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_TOPIC_ID)
	private Topic topic;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_QUESTION_TYPE_ID)
	private QuestionType type;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_DIFFICULTY_ID)
	private QuestionDifficulty difficulty;

	@OneToMany(mappedBy="question", cascade=CascadeType.ALL)
	private Set<QuestionOption> options;

	@Column(name = Constants.COLUMN_QTEXT)
	private String text;

	public Question(Topic topic, QuestionType type, QuestionDifficulty difficulty, String text) {
		this.topic = topic;
		this.type = type;
		this.difficulty = difficulty;
		this.text = text;
	}

	public Question() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long questionId) {
		this.id = questionId;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public QuestionType getType() {
		return type;
	}

	public void setType(QuestionType type) {
		this.type = type;
	}

	public QuestionDifficulty getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(QuestionDifficulty difficulty) {
		this.difficulty = difficulty;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", topic=" + topic + ", type=" + type
				+ ", difficulty=" + difficulty + ", text=" + text + "]";
	}

}
