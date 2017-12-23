package io.revlearners.model.bean;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_CHALLENGE_ATTEMPT)
public class ChallengeAttempt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -460168171956593784L;

	@Id
	@Column(name=Constants.COLUMN_ATTEMPT_ID)
	@SequenceGenerator(sequenceName="CATT_SEQ", name="CATT_SEQ")
    @GeneratedValue(generator="CATT_SEQ", strategy=GenerationType.SEQUENCE)	
	private Long id;
	
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_CHALLENGE_ID, referencedColumnName = Constants.COLUMN_CHALLENGE_ID)
	private Challenge chal;
    
	@ManyToMany(targetEntity=QuestionOption.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_CHALLENGE_ATTEMPT_ANSWERS, joinColumns=@JoinColumn(name=Constants.COLUMN_ATTEMPT_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_OPTION_ID))
	private Set<QuestionOption> answers = new HashSet<QuestionOption>();
	
	@ManyToMany(targetEntity=User.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinTable(name=Constants.TABLE_USER_CHALLENGE_ATTEMPT, joinColumns=@JoinColumn(name=Constants.COLUMN_ATTEMPT_ID), inverseJoinColumns=@JoinColumn(name=Constants.COLUMN_USER_ID))
	private Set<User> users = new HashSet<User>();
	
	public ChallengeAttempt() {	
	}
	
	public ChallengeAttempt(Set<User> users, Set<QuestionOption> answers) {
		this.answers = answers;
		this.users = users;
	}

	public Challenge getChal() {
		return chal;
	}

	public void setChal(Challenge chal) {
		this.chal = chal;
	}

	public Set<QuestionOption> getAnswers() {
		return answers;
	}

	public void setAnswers(Set<QuestionOption> answers) {
		this.answers = answers;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
