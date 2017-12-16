package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name="rank")
public class Rank {

    @Id
    @Column(name = "rank_id")
    @SequenceGenerator(name = "seq_gen_rank", sequenceName = "seq_rank", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_rank")
    private long id;

    @Column(name="rank_name")
    private String name;

    @Column(name="merit_threshold")
    private long meritThreshold;


    public Rank(String name, long meritThreshold) {
        this.name = name;
        this.meritThreshold = meritThreshold;
    }

    public Rank() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMeritThreshold() {
        return meritThreshold;
    }

    public void setMeritThreshold(long meritThreshold) {
        this.meritThreshold = meritThreshold;
    }
}
