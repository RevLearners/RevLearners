package io.revlearners.model.bean;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER")
public class User implements Serializable {
	private static final long serialVersionUID = 8799966307722508679L;

	@Id
	@Column(name="USER_ID")
	@SequenceGenerator(
			sequenceName="USER_SEQ", 
			name="USER_SEQ")
	@GeneratedValue(
			generator="USER_SEQ", 
			strategy=GenerationType.SEQUENCE)
	private int userId;

	@Column(name="FNAME")
	private String firstName;

	@Column(name="MNAME")
	private String middleName;
	
	@Column(name="LNAME")
	private String lastName;

	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private UserStatus status;

	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private UserRole role;

	@ManyToMany
	@JoinTable(name="FRIENDS")
	private List<User> friends;
	
	public User() {
	
	}
		
	public User(int userId, String firstName, String middleName, String lastName, UserStatus status, UserRole role,
			List<User> friends) {
		this.userId = userId;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.status = status;
		this.role = role;
		this.friends = friends;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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
