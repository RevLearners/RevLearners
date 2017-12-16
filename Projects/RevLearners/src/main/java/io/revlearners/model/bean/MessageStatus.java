package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name="message_status")
public class MessageStatus {
    @Id
    @Column(name = "status_id")
    @SequenceGenerator(name = "seq_gen_message_status", sequenceName = "seq_message_status", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_message_status")
    private long id;

    @Column(name = "message_status_name")
    private String name;

    public MessageStatus() {
    }

    public MessageStatus(String name) {

        this.name = name;
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
}
