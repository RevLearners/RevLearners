package io.revlearners.model.bo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.revlearners.util.commons.configs.Constants;

public class UserBo implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9102984883242741488L;

	private Long id;

	private String firstName;

	private String middleName;

	private String lastName;

	private Long statId;
	
	private String status;

	private Long roleId;
	
	private String role;
	
	private String email;
	
	private String username;
	
	private String password;
	
	private boolean enabled;
	
	private LocalDateTime lastPasswordReset;

	public LocalDateTime getLastPasswordReset() {
		return lastPasswordReset;
	}

	public void setLastPasswordReset(LocalDateTime lastPasswordReset) {
		this.lastPasswordReset = lastPasswordReset;
	}

	private Set<UserBo> friends;

	private Set<UserRankBo> ranks;

	private Set<ChallengeBo> challenges;

	private Set<ChallengeAttemptBo> challengeAttempts;

	private Set<UserCertificationBo> certifications;

	private Set<String> permissions;
	
	
	public Set<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<String> permissions) {
		this.permissions = permissions;
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

	public UserBo() {
	}
	
	public UserBo(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public UserBo(String firstName, String middleName, String lastName, String username, String password, String email) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}
	
	public UserBo(Long id, String firstName, String middleName, String lastName, String email, String username,
			String password, LocalDateTime ldt, Long roleId, String roleName, Long statId, String statName, Set<UserRankBo> ranks,
			Set<UserCertificationBo> certs, Set<ChallengeAttemptBo> chalAttempts, Set<ChallengeBo> challenges,
			Set<UserBo> friends, Set<String> permissions) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.statId = statId;
		this.status = statName;
		this.roleId = roleId;
		this.role = roleName;
		this.ranks = ranks;
		this.friends = friends;
		this.permissions = permissions;
		this.lastPasswordReset = ldt;
	}

	public Long getStatId() {
		return statId;
	}

	public void setStatId(Long statId) {
		this.statId = statId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Set<UserRankBo> getRanks() {
		return ranks;
	}

	public void setRanks(Set<UserRankBo> ranks) {
		this.ranks = ranks;
	}

	public Set<UserCertificationBo> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<UserCertificationBo> certifications) {
		this.certifications = certifications;
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

	public Set<UserBo> getFriends() {
		return friends;
	}

	public void setFriends(Set<UserBo> friends) {
		this.friends = friends;
	}

	public Set<ChallengeBo> getChallenges() {
		return challenges;
	}

	public void setChallenges(Set<ChallengeBo> challenges) {
		this.challenges = challenges;
	}

	public Set<ChallengeAttemptBo> getChallengeAttempts() {
		return challengeAttempts;
	}

	public void setChallengeAttempts(Set<ChallengeAttemptBo> challengeAttempts) {
		this.challengeAttempts = challengeAttempts;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		return statId.equals(Constants.STATUS_OK);
	}
}
