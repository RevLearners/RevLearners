package io.revlearners.util.commons.security;

import java.time.LocalDateTime;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * This class was made in reference to the guide by Steven Zerhusen on basic JWT
 * token authentication
 */
public class JwtUser implements UserDetails {

	private final Long id;
	private final String username;
	private final String firstname;
	private final String lastname;
	private final String password;
	private final String email;
	private final boolean enabled;
	private final Collection<? extends GrantedAuthority> authorities;
	private final LocalDateTime lastPasswordReset;

	public LocalDateTime getLastPasswordReset() {
		return lastPasswordReset;
	}

	public JwtUser(Long id, String username, String firstName, String middleName, String lastName, String email, String password,
			boolean enabled, Collection<? extends GrantedAuthority> authorities, LocalDateTime lastPasswordReset) {
		this.id = id;
		this.username = username;
		this.firstname = firstName;
		this.lastname = lastName;
		this.email = email;
		this.password = password;
		this.enabled = enabled;
		this.authorities = authorities;
		this.lastPasswordReset = lastPasswordReset;
	}

	@JsonIgnore
	public Long getId() {
		return id;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@JsonIgnore
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	@JsonIgnore
	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isEnabled() {
		return enabled;
	}
}