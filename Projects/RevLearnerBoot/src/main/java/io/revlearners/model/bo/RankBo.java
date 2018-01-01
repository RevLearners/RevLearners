package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;

public class RankBo {

    private Long rankId;
    private String rankName;
    private Long topicId;
    private String topicName;
    private Long relativeWeight;
    
    public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	private Float meritThreshold;

    public RankBo() {
    }

    public RankBo(Long rankId, String rankName, Long topicId, String topicName, Long relativeWeight, Float meritThreshold) {
    		this.rankId = rankId;
    		this.topicName = rankName;
    		this.topicId = topicId;
    		this.topicName = topicName;
    		this.relativeWeight = relativeWeight;
    		this.meritThreshold = meritThreshold;
	}

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getRelativeWeight() {
        return relativeWeight;
    }

    public void setRelativeWeight(Long relativeWeight) {
        this.relativeWeight = relativeWeight;
    }

    public Float getMeritThreshold() {
        return meritThreshold;
    }

    public void setMeritThreshold(Float meritThreshold) {
        this.meritThreshold = meritThreshold;
    }

    public Long getRankId() {
        return rankId;
    }

    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    public String getRankName() {
        return rankName;
    }

    public void setRankName(String rankName) {
        this.rankName = rankName;
    }
}
