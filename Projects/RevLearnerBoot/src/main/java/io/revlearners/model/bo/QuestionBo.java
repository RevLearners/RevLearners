package io.revlearners.model.bo;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import io.revlearners.model.bean.QuestionType;
import io.revlearners.util.commons.configs.Constants;

public class QuestionBo {

    private Long id;
    private TopicBo topic;
    private QuestionTypeBo type;
    private QuestionDifficultyBo difficulty;
    private Set<QuestionOptionBo> options;
    private String text;
    private String explanation;

    public QuestionBo(TopicBo topic, QuestionTypeBo type, QuestionDifficultyBo difficulty, String text, String explanation) {
        this.topic = topic;
        this.type = type;
        this.difficulty = difficulty;
        this.text = text;
        this.explanation = explanation;
    }

    public QuestionBo(Long id) {
        this.id = id;
    }

    public Set<QuestionOptionBo> getOptions() {
        return options;
    }

    public void setOptions(Set<QuestionOptionBo> options) {
        this.options = options;
    }

    public QuestionBo() {
    }

	public QuestionBo(Long id, String text, String topicName, String diff, String type, QuestionOptionBo answer,
			String explanation, double score, Set<QuestionOptionBo> options) {
	}

	public Long getId() {
        return id;
    }

    public void setId(Long questionId) {
        this.id = questionId;
    }

    public TopicBo getTopic() {
        return topic;
    }

    public void setTopic(TopicBo topic) {
        this.topic = topic;
    }

    public QuestionTypeBo getType() {
        return type;
    }

    public void setType(QuestionTypeBo type) {
        this.type = type;
    }

    public QuestionDifficultyBo getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(QuestionDifficultyBo difficulty) {
        this.difficulty = difficulty;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    @Override
    public String toString() {
        return "Question [id=" + id + ", topic=" + topic + ", type=" + type
                + ", difficulty=" + difficulty + ", text=" + text + "]";
    }

}
