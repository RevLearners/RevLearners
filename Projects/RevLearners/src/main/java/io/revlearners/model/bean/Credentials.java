package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name=Constants.TABLE_USER_CREDENTIALS)
public class Credentials implements Serializable {

	private static final long serialVersionUID = -4553263186684526703L;

    @Id
    @Column(name=Constants.COLUMN_USER_ID)
	private Long id;

	@MapsId
    @OneToOne
	@JoinColumn(name=Constants.COLUMN_USER_ID)
	private User user;

	@Column(name=Constants.COLUMN_EMAIL)
	private String email;

	@Column(name=Constants.COLUMN_USERNAME)
	private String username;

	@Column(name=Constants.COLUMN_PASSWORD)
	private String password;

	@Column(name=Constants.COLUMN_SALT)
	private String salt;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Credentials() {
	}

	public Credentials(User user, String email, String username, String password, String salt) {
		this.user = user;
		this.email = email;
		this.username = username;
		this.password = password;
		this.salt = salt;
	}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
