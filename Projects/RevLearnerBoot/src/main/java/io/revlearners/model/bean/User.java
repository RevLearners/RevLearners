package io.revlearners.model.bean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_APP_USER)
@SecondaryTables({@SecondaryTable(name = Constants.TABLE_USER_CREDENTIALS)})
public class User implements Serializable {
    private static final long serialVersionUID = 8799966307722508679L;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Id
    @Column(name = Constants.COLUMN_USER_ID)
    @SequenceGenerator(sequenceName = "USER_SEQ", name = "USER_SEQ")
    @GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
    private Long id;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name = Constants.COlUMN_FNAME)
    private String firstName;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name = Constants.COLUMN_MNAME)
    private String middleName;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(name = Constants.COLUMN_LNAME)
    private String lastName;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @ManyToOne
    @JoinColumn(name = Constants.COLUMN_STATUS_ID)
    private UserStatus status;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @ManyToOne
    @JoinColumn(name = Constants.COLUMN_ROLE_ID)
    private UserRole role;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = Constants.TABLE_FRIEND, joinColumns = @JoinColumn(name = Constants.COLUMN_USER_ID), inverseJoinColumns = @JoinColumn(name = Constants.COLUMN_FRIEND_ID))
    private Set<User> friends;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @OneToMany(mappedBy = Constants.PK_USER, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserRank> ranks;

    @ManyToMany(mappedBy = "users")
    private Set<Challenge> challenges;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<ChallengeAttempt> challengeAttempts;

    @OneToMany(mappedBy = Constants.PK_USER, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<UserCertification> certifications;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(table = Constants.TABLE_USER_CREDENTIALS, name = Constants.COLUMN_EMAIL)
    private String email;

    @JsonView({Views.ToBackEnd.class, Views.ToFrontEnd.class})
    @Column(table = Constants.TABLE_USER_CREDENTIALS, unique = true, name = Constants.COLUMN_USERNAME)
    private String username;

    @JsonView({Views.ToBackEnd.class})
    @Column(table = Constants.TABLE_USER_CREDENTIALS, name = Constants.COLUMN_PASSWORD_HASH)
    private String password;
    
    @Column(name = Constants.COLUMN_LAST_PW_RESET)
    private LocalDateTime lastPasswordReset;

    public User(String firstName, String middleName, String lastName, UserStatus status, UserRole role, 
    		String email, String username, String password, LocalDateTime ldt) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.status = status;
        this.role = role;
        this.email = email;
        this.username = username;
        this.password = password;
        this.lastPasswordReset = ldt;
    }

    public User() {
    }

    public LocalDateTime getLastPasswordReset() {
		return lastPasswordReset;
	}

	public void setLastPasswordReset(LocalDateTime lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<UserRank> getRanks() {
        return ranks;
    }

    public void setRanks(Set<UserRank> ranks) {
        this.ranks = ranks;
    }

    public boolean addCertification(Set<UserCertification> certs) {
        return certifications.addAll(certs);
    }

    public boolean deleteCertifications(Set<UserCertification> certs) {
        return certifications.removeAll(certs);
    }

    public Set<UserCertification> getCertifications() {
        return certifications;
    }

    public void setCertifications(Set<UserCertification> certifications) {
        this.certifications = certifications;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public Set<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(Set<Challenge> challenges) {
        this.challenges = challenges;
    }

    public Set<ChallengeAttempt> getChallengeAttempts() {
        return challengeAttempts;
    }

    public void setChallengeAttempts(Set<ChallengeAttempt> challengeAttempts) {
        this.challengeAttempts = challengeAttempts;
    }
}
