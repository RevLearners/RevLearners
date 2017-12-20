package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table (name=Constants.TABLE_TOPIC)
public class Topic implements Serializable{
	private static final long serialVersionUID = -7336698542678175301L;

	@Id
	@Column (name=Constants.COLUMN_TOPIC_ID)
	private Long id;

	@Column(name=Constants.COLUMN_TOPIC_NAME)
	private String topicName;

    public Topic(Long id, String topicName) {
        this.id = id;
        this.topicName = topicName;
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
}
