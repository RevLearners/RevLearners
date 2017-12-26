package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;

public class CertificationBo {


	private Long id;
	private String name;
	private TopicBo topic;
	private Set<UserCertificationBo> users;
	
	public boolean addUsers(Set<UserCertificationBo> users) {
		return this.users.addAll(users);
	}

	public boolean deleteUsers(Set<UserCertificationBo> users) {
		return this.users.removeAll(users);
	}

	public Set<UserCertificationBo> getUsers() {
		return users;
	}

	public void setUsers(Set<UserCertificationBo> users) {
		this.users = users;
	}

	public CertificationBo() {
	}

	public CertificationBo(Long id) {
		this.id = id;
	}

	public CertificationBo(Long id, String name, TopicBo topic) {
		this.id = id;
		this.name = name;
		this.topic = topic;
	}

	public TopicBo getTopic() {
		return topic;
	}

	public void setTopic(TopicBo topic) {
		this.topic = topic;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
