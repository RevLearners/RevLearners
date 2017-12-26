package io.revlearners.model.bo;

import java.io.Serializable;
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

	private Long statId;
	
	private String status;

	private Long roleId;
	
	private String role;

	private Set<UserBo> friends;

	private Map<Long, RankBo> ranks;

	private Set<ChallengeBo> challenges;

	private Set<ChallengeAttemptBo> challengeAttempts;

	private Set<CertificationBo> certifications;

	private String email;

	private String username;

	private String password;

	private String salt;

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

	public UserBo() {
	}

	public UserBo(Long id, String firstName, String middleName, String lastName, String email, String username,
			Long roleId, String role, Long statId, String stat, Map<Long, RankBo> ranks, Set<CertificationBo> certs,
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

	public Map<Long, RankBo> getRanks() {
		return ranks;
	}

	public void setRanks(Map<Long, RankBo> ranks) {
		this.ranks = ranks;
	}

	public Set<CertificationBo> getCertifications() {
		return certifications;
	}

	public void setCertifications(Set<CertificationBo> certifications) {
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
