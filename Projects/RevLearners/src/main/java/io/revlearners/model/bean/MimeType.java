package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="MIME_TYPE")
public class MimeType implements Serializable {
    @Id
    @Column(name = "MIME_ID")
    @SequenceGenerator(name = "SEQ_GEN_MIME_TYPE", sequenceName = "SEQ_MIME_TYPE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_MIME_TYPE")
    private Long id;

    @Column(name = "MIME_NAME")
    private String name;

    public MimeType() {
    }

    public MimeType(String name) {
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
