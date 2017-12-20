package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;

@Entity
@Table(name=Constants.TABLE_RANK)
public class Rank implements Serializable {

    /**
	 *
	 */
	private static final long serialVersionUID = -5410626868066784809L;

	@Id
    @Column(name = Constants.COLUMN_RANK_ID)
    private Long id;

    @Column(name=Constants.COLUMN_RANK_NAME)
    private String name;

    @Column(name=Constants.COLUMN_RANK_IN_HEIRARCHY)
    private Long rank;

    @Column(name=Constants.COLUMN_MERIT_THRESHOLD)
    private Long meritThreshold;


    public Rank(Long id, String name, Long meritThreshold, Long rankInHeirarchy) {
        this.id = id;
        this.name = name;
        this.meritThreshold = meritThreshold;
        this.rank = rankInHeirarchy;
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

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Long getMeritThreshold() {
        return meritThreshold;
    }

    public void setMeritThreshold(Long meritThreshold) {
        this.meritThreshold = meritThreshold;
    }
}
