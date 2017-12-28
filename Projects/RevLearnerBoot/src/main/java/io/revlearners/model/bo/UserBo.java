package io.revlearners.model.bo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

public class UserBo {
	private static final long serialVersionUID = 8799966307722508679L;

	private Long id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Long statId;
	private String status;
	private Long roleId;
	private String role;
	private Set<UserBo> friends;
	private Set<UserRankBo> ranks;
	private Set<ChallengeBo> challenges;
	private Set<ChallengeAttemptBo> challengeAttempts;
	private Set<UserCertificationBo> certifications;
	private List<String> permissions;
	
	public UserBo() {
	}
	
	public UserBo(Long id, String firstName, String middleName, String lastName, String email, String username,
			Long roleId, String role, Long statId, String stat, Set<UserRankBo> ranks, Set<UserCertificationBo> certs,
			Set<ChallengeAttemptBo> attempts, Set<ChallengeBo> challenges, Set<UserBo> friends) {
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.roleId = roleId;
		this.role = role;
		this.statId = statId;
		this.status = stat;
		this.ranks = ranks;
		this.certifications = certs;
		this.challengeAttempts = attempts;
		this.challenges = challenges;
		this.friends = friends;
	}
	
	public List<String> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<String> permissions) {
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
}
