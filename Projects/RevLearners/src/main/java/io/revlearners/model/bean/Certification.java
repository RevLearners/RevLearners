package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="CERTIFICAITON")
public class Certification implements Serializable {

    @Id
    @Column(name = "CERTIFICATION_ID")
    @SequenceGenerator(name = "SEQ_GEN_CERTIFICATION", sequenceName = "SEQ_CERTIFICATION", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_CERTIFICATION")
    private Long id;

    @Column(name="CERTIFICATION_NAME")
    private String name;

    @ManyToOne
    @JoinColumn(name="TOPIC_ID")
    private Topic topic;

    public Certification() {
    }

    public Certification(String name, Topic topic) {
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
