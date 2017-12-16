package io.revlearners.model.bean;

import javax.persistence.*;

@Entity
@Table(name="user_role")
public class UserRole {

    @Id
    @Column(name = "role_id")
    @SequenceGenerator(name = "seq_gen_user_role", sequenceName = "seq_user_role", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_user_role")
    private long id;

    @Column(name = "role_name")
    private String name;

    public UserRole() {
    }

    public UserRole(String name) {
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
