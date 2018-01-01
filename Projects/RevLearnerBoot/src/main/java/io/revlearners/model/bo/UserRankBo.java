package io.revlearners.model.bo;

public class UserRankBo {

	private String rankName;
	private Long rankId;
	private Float merit;
    private Float threshold;
	private String topicName;
	private Long topicId;
	
	public UserRankBo() {
	}

	public UserRankBo(Long id, String name, Float merit, Float threshold,
                      Long topicId, String topicName) {
		this.rankName = name;
		this.rankId = id;
		this.merit = merit;
		this.threshold = threshold;
		this.topicName = topicName;
		this.topicId = topicId;
	}

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getRankName() {
		return rankName;
	}

	public void setRankName(String rankName) {
		this.rankName = rankName;
	}

	public Long getRankId() {
		return rankId;
	}

	public void setRankId(Long rankId) {
		this.rankId = rankId;
	}

	public Float getMerit() {
		return merit;
	}

	public void setMerit(Float merit) {
		this.merit = merit;
	}

    public Float getThreshold() {
        return threshold;
    }

    public void setThreshold(Float threshold) {
        this.threshold = threshold;
    }
}
