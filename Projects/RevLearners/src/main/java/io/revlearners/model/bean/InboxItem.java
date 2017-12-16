package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inbox_item")
public class InboxItem implements Serializable {
    @Id
    @Column(name = "bean_id")
    @SequenceGenerator(name = "seq_gen_inbox_item", sequenceName = "seq_inbox_item", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_inbox_item")
    private Long id;

    @Column(name = "bean_message")
    private String message;

    public InboxItem(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

