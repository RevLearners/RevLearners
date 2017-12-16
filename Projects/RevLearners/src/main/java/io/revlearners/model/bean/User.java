package io.revlearners.model.bean;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 8799966307722508679L;

    @Id
    @Column(name = "user_id")
    @SequenceGenerator(name = "seq_gen_user", sequenceName = "seq_user", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_user")
    private long id;

    @Column(name = "user_name")
    private String name;

    @ManyToOne
    @JoinColumn(name="status_id")
    private UserStatus status;

    @ManyToOne
    @JoinColumn(name="role_id")
    private UserRole role;

    public User() {
    }

    public User(String name, UserStatus status, UserRole role) {
        this.name = name;
        this.status = status;
        this.role = role;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
