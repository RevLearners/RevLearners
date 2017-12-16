package io.revlearners.model.bean;

import java.util.List;
import java.io.Serializable;

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

	@Column(name="USERNAME")
	private String username;

	@ManyToOne
	@JoinColumn(name="STATUS_ID")
	private int statusId;

	@ManyToOne
	@JoinColumn(name="ROLE_ID")
	private int roleId;

	@ManyToMany
	@JoinTable(name="FRIENDS")
	private List<User> friends;
	
	public User() {
	
	}

	public User(int userId, String username, int statusId, int roleId) {
		this.userId = userId;
		this.username = username;
		this.statusId = statusId;
		this.roleId = roleId;
	}
		
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
}
