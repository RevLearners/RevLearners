package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name="certificaiton")
public class Certification {

    @Id
    @Column(name = "certification_id")
    @SequenceGenerator(name = "seq_gen_certification", sequenceName = "seq_certification", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_certification")
    private long id;

    @Column(name="certification_name")
    private String name;

    @ManyToOne
    @JoinColumn(name="lang_id")
    private Language language;

    public Certification() {
    }

    public Certification(String name, Language language) {
        this.name = name;
        this.language = language;
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

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }
}
