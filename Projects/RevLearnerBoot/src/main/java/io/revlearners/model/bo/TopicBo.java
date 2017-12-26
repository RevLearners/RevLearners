package io.revlearners.model.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

import io.revlearners.util.commons.configs.Constants;

public class TopicBo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 829572710870545731L;
	private Long id;
	private String topicName;
	private Set<RankBo> ranks = new HashSet<RankBo>();

	public TopicBo(Long id, String topicName, Set<RankBo> ranks) {
		this.id = id;
		this.topicName = topicName;
		this.ranks = ranks;
	}

	public Set<RankBo> getRanks() {
		return ranks;
	}

	public void setRanks(Set<RankBo> ranks) {
		this.ranks = ranks;
	}

	public TopicBo(Long id) {
		this.id = id;
	}

	public TopicBo() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTopicName() {
		return topicName;
	}

	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	@Override
	public String toString() {
		return "Topic [id=" + id + ", topicName=" + topicName + "]";
	}


    /**
     * given a topic and a rank weight (in the heirarchy of ranks for the topic)
     * we return the next rank in the sequence
     *
     * @param i
     * @return
     */
	public RankBo getRankByWeight(Long i) {
		for (RankBo r : ranks) {
			if (r.getRelativeWeight().equals(i))
				return r;
		}
		return null;
	}
}
