package io.revlearners.model.bean;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name=Constants.TABLE_RANK)
public class Rank implements Serializable {

	private static final long serialVersionUID = -5410626868066784809L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
	@Id
    @Column(name = Constants.COLUMN_RANK_ID)
    private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name=Constants.COLUMN_RANK_NAME)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_TOPIC_ID, referencedColumnName = Constants.COLUMN_TOPIC_ID)
    private Topic topic;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name=Constants.COLUMN_RANK_IN_HEIRARCHY)
    private Long relativeWeight;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name=Constants.COLUMN_MERIT_THRESHOLD)
    private Float meritThreshold;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = Constants.PK_RANK)
    private Set<UserRank> users;

    public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

    public Rank(Long id, String name, Long rankInHeirarchy, Float meritThreshold) {
        this.id = id;
        this.name = name;
        this.meritThreshold = meritThreshold;
        this.relativeWeight = rankInHeirarchy;
    }

    public Rank() {
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

    public Float getMeritThreshold() {
        return meritThreshold;
    }

    public void setMeritThreshold(Float meritThreshold) {
        this.meritThreshold = meritThreshold;
    }
}
