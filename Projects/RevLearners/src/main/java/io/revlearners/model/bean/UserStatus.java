package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name="user_status")
public class UserStatus {
    @Id
    @Column(name = "status_id")
    @SequenceGenerator(name = "seq_gen_user_status", sequenceName = "seq_user_status", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_user_status")
    private long id;

    @Column(name = "user_status_name")
    private String name;

    public UserStatus() {
    }

    public UserStatus(String name) {

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
