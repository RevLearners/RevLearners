
package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.Set;


public class UserCertificationBo {

    private Long id;
    private String name;
    private String topic;
    private String status;

    public UserCertificationBo() {
    }

    public UserCertificationBo(Long id, String name, String topic, String status) { 
    		this.id = id;
    		this.name = name;
    		this.topic = topic;
    		this.status = status;
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
