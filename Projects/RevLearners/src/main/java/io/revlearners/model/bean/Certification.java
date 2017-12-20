package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name=Constants.TABLE_CERTIFICATION)
public class Certification implements Serializable {


	private static final long serialVersionUID = 6064749272111879848L;

	@Id
    @Column(name = Constants.COLUMN_CERTIFICATION_ID)
    private Long id;

    @Column(name=Constants.COLUMN_CERTIFICATION_NAME)
    private String name;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_TOPIC_ID)
    private Topic topic;

    public Certification() {
    }

    public Certification(Long id) {
        this.id = id;
    }

    public Certification(Long id, String name, Topic topic) {
        this.id = id;
        this.name = name;
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
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
}
