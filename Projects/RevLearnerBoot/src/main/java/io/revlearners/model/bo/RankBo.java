package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;

public class RankBo {

    private Long id;
    private String name;
    private Long topicId;
    private String topic;
    private Long relativeWeight;
    
    public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	private Long meritThreshold;

    public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

    public RankBo() {
    }

    public RankBo(Long id, String name, Long topicId, String topic, Long relativeWeight, Long meritThreshold) {
    		this.id = id;
    		this.name = name;
    		this.topicId = topicId;
    		this.topic = topic;
    		this.relativeWeight = relativeWeight;
    		this.meritThreshold = meritThreshold;
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

    public Long getRelativeWeight() {
        return relativeWeight;
    }

    public void setRelativeWeight(Long relativeWeight) {
        this.relativeWeight = relativeWeight;
    }

    public Long getMeritThreshold() {
        return meritThreshold;
    }

    public void setMeritThreshold(Long meritThreshold) {
        this.meritThreshold = meritThreshold;
    }
}
