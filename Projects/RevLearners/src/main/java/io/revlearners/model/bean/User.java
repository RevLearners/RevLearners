package io.revlearners.model.bean;

import java.io.Serializable;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "APP_USER")
public class User implements Serializable {
    private static final long serialVersionUID = 8799966307722508679L;

    @Id
    @Column(name = "USER_ID")
    @SequenceGenerator(sequenceName = "USER_SEQ", name = "USER_SEQ")
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    private Long userId;

    @Column(name = "FNAME")
    private String firstName;

    @Column(name = "MNAME")
    private String middleName;

    @Column(name = "LNAME")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "STATUS_ID")
    private UserStatus status;

    @ManyToOne
    @JoinColumn(name = "ROLE_ID")
    private UserRole role;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "FRIEND", joinColumns = @JoinColumn(name = "USER1_ID"), inverseJoinColumns = @JoinColumn(name = "USER2_ID"))
    private List<User> friends;

    public User() {
    }

    public User(String firstName, String middleName, String lastName, UserStatus status, UserRole role) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.status = status;
        this.role = role;
    }

    public Long getId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
