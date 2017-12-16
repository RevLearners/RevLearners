package io.revlearners.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inbox_item")
public class InboxItem implements Serializable {
    @Id
    @Column(name = "bean_id")
    @SequenceGenerator(name = "seq_gen_inbox_item", sequenceName = "seq_inbox_item", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_inbox_item")
    Long id;

    @Column(name = "bean_message")
    private String message;

    public InboxItem(String message) {
        this.message = message;
    }
}

