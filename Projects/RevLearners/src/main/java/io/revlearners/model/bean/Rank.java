package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="RANK")
public class Rank implements Serializable {

    @Id
    @Column(name = "RANK_ID")
    @SequenceGenerator(name = "SEQ_GEN_RANK", sequenceName = "SEQ_RANK", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_RANK")
    private Long id;

    @Column(name="RANK_NAME")
    private String name;

    @Column(name="MERIT_THRESHOLD")
    private Long meritThreshold;


    public Rank(String name, Long meritThreshold) {
        this.name = name;
        this.meritThreshold = meritThreshold;
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

    public Long getMeritThreshold() {
        return meritThreshold;
    }

    public void setMeritThreshold(Long meritThreshold) {
        this.meritThreshold = meritThreshold;
    }
}
