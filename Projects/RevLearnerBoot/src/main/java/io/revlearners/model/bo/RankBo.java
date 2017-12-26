package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;

public class RankBo {

    private Long id;
    private String name;
    private String topic;
    private Long relativeWeight;
    private Long meritThreshold;

    public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

    public RankBo(Long id, String name, Long rankInHeirarchy, Long meritThreshold) {
        this.id = id;
        this.name = name;
        this.meritThreshold = meritThreshold;
        this.relativeWeight = rankInHeirarchy;
    }

    public RankBo() {
    }

    public RankBo(Long id, String name, String topic, Long relativeWeight, Long meritThreshold) {
    		this.id = id;
    		this.name = name;
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
