package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="MESSAGE_STATUS")
public class MessageStatus implements Serializable {
    @Id
    @Column(name = "STATUS_ID")
    @SequenceGenerator(name = "SEQ_GEN_MESSAGE_STATUS", sequenceName = "SEQ_MESSAGE_STATUS", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_MESSAGE_STATUS")
    private Long id;

    @Column(name = "MESSAGE_STATUS_NAME")
    private String name;

    public MessageStatus() {
    }

    public MessageStatus(String name) {
        this.name = name;
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
