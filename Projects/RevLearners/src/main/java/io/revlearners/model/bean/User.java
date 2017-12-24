package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_APP_USER)
@SecondaryTables({ @SecondaryTable(name = Constants.TABLE_USER_CREDENTIALS) })
public class User implements Serializable {
	private static final long serialVersionUID = 8799966307722508679L;

	@Id
	@Column(name = Constants.COLUMN_USER_ID)
	@SequenceGenerator(sequenceName = "USER_SEQ", name = "USER_SEQ")
	@GeneratedValue(generator = "USER_SEQ", strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name = Constants.COlUMN_FNAME)
	private String firstName;

	@Column(name = Constants.COLUMN_MNAME)
	private String middleName;

	@Column(name = Constants.COLUMN_LNAME)
	private String lastName;

	@ManyToOne
	@JoinColumn(name = Constants.COLUMN_STATUS_ID)
	private UserStatus status;

	@ManyToOne
	@JoinColumn(name = Constants.COLUMN_ROLE_ID)
	private UserRole role;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = Constants.TABLE_FRIEND, joinColumns = @JoinColumn(name = Constants.COLUMN_USER_ID), inverseJoinColumns = @JoinColumn(name = Constants.COLUMN_FRIEND_ID))
	private List<User> friends;
	
	@Column(table = Constants.TABLE_USER_CREDENTIALS, name = Constants.COLUMN_EMAIL)
	private String email;

	@Column(table = Constants.TABLE_USER_CREDENTIALS, name = Constants.COLUMN_USERNAME)
	private String username;

	@Column(table = Constants.TABLE_USER_CREDENTIALS, name = Constants.COLUMN_PASSWORD_HASH)
	private String password;

	@Column(table = Constants.TABLE_USER_CREDENTIALS, name = Constants.COLUMN_SALT)
	private String salt;
	
	@OneToMany(mappedBy = Constants.PK_USER, cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserCertification> certifications;
	
	@OneToMany(mappedBy = Constants.PK_USER, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserRank> ranks;
	
	@OneToMany(mappedBy = Constants.USER, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<QuizAttempt> quizzes;
	
	@OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name=Constants.COLUMN_USER_ID)
	private List<ChallengeAttempt> challenges;
	
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

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public List<UserRank> getRanks() {
		return ranks;
	}

	public void setRanks(List<UserRank> ranks) {
		this.ranks = ranks;
	}

	public boolean addCertification(List<UserCertification> certs) {
		return certifications.addAll(certs);
	}
	
	public boolean deleteCertifications(List<UserCertification> certs) {
		return certifications.removeAll(certs);
	}
	
	public List<UserCertification> getCertifications() {
		return certifications;
	}

	public void setCertifications(List<UserCertification> certifications) {
		this.certifications = certifications;
	}

	public User() {
	}

	public User(String firstName, String middleName, String lastName, UserStatus status, UserRole role, 
			String email, String username, String password, String salt) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.status = status;
		this.role = role;
		this.email = email;
		this.username = username;
		this.password = password;
		this.salt = salt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long userId) {
		this.id = userId;
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
