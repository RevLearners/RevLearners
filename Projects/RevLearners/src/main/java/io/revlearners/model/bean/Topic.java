package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.FetchType;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_TOPIC)
public class Topic implements Serializable {
	private static final long serialVersionUID = -7336698542678175301L;

	@Id
	@Column(name = Constants.COLUMN_TOPIC_ID)
	private Long id;

	@Column(name = Constants.COLUMN_TOPIC_NAME)
	private String topicName;

	@OneToMany(mappedBy = Constants.FK_TOPIC, fetch = FetchType.EAGER)
	private Set<Rank> ranks = new HashSet<Rank>();

	public Topic(Long id, String topicName, Set<Rank> ranks) {
		this.id = id;
		this.topicName = topicName;
	}

	public Set<Rank> getRanks() {
		return ranks;
	}

	public void setRanks(Set<Rank> ranks) {
		this.ranks = ranks;
	}

	public Topic(Long id) {
		this.id = id;
	}

	public Topic() {
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
	public Rank getRankByWeight(Long i) {
		for (Rank r : ranks) {
			if (r.getRelativeWeight().equals(i))
				return r;
		}
		return null;
	}
}
