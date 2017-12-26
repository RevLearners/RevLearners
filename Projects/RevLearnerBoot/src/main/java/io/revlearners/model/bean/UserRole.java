package io.revlearners.model.bean;

import java.io.Serializable;
import io.revlearners.util.commons.configs.Constants;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A role determines whether use user is a regular user, or an
 * administrator;
 *
 * A regular user can be apply for an get certified, generate and
 * complete, and send quizzes (as challenges), etc. If the regular
 * User's rank is high enough in a topic, the user can create questions
 * to, or is certified in a topic, then the user can also add questions
 * toward that topic's pool of questions, etc
 *      - In other words, for the regular user, there are a set
 *          of 'roles' also called ranks that are each tied to topic
 *          a topic, the user can advance in rank the more question
 *          a user answers in that topic. When the user answers enough
 *          questions to pass the threshold of the topic's rank, their
 *          rank advances in that topic.
 *
 * An admin user can approve or deny certification requests, as well
 * as lock/unlock user accounts
 *
 */
@Entity
@Table(name=Constants.TABLE_USER_ROLE)
public class UserRole implements Serializable {

	private static final long serialVersionUID = 4523050103926297436L;

	@Id
	@Column(name=Constants.COLUMN_ROLE_ID)
	private Long id;

	@Column(name=Constants.COLUMN_ROLE_NAME)
	private String name;

	public UserRole() {
	}

    public UserRole(Long id) {
        this.id = id;
    }

    public UserRole(Long id, String name) {
        this.id = id;
        this.name = name;
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
