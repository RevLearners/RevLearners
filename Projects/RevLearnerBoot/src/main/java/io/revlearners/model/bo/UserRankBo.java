package io.revlearners.model.bo;

public class UserRankBo {

	private String rankName;
	private Long rankId;
	private Long merit;
	private String topic;
	
	public UserRankBo() {
	}

	public UserRankBo(Long id, String name, Long merit, String topic) {
		this.rankName = name;
		this.rankId = id;
		this.merit = merit;
		this.topic = topic;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
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

	public Long getMerit() {
		return merit;
	}

	public void setMerit(Long merit) {
		this.merit = merit;
	}
	
	
}
