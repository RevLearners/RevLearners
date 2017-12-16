package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="CREDENTIALS")
public class Credentials implements Serializable {

	private static final long serialVersionUID = -4553263186684526703L;

	@Id
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="SALT")
	private String salt;

	public Credentials() {

	}

	public Credentials(User user, String email, String password, String salt) {
		this.user = user;
		this.email = email;
		this.password = password;
		this.salt = salt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
	
}
