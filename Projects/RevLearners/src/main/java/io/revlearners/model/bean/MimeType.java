package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="mime_type")
public class MimeType implements Serializable {
    @Id
    @Column(name = "mime_id")
    @SequenceGenerator(name = "seq_gen_mime_type", sequenceName = "seq_mime_type", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_mime_type")
    private long id;

    @Column(name = "mime_name")
    private String name;

    public MimeType() {
    }

    public MimeType(String name) {
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
