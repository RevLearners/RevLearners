package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.model.bean.MessageStatus;
import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class NotificationBo {

    private Long id;
    private UserBo sender;
    private Set<UserBo> receivers = new HashSet<UserBo>();
    private String title;
    private String contents;
    private LocalDateTime time;
    private MessageStatusBo status;

    public NotificationBo() {
    }

    public NotificationBo(UserBo sender, Set<UserBo> receivers, String title, String contents, LocalDateTime time, MessageStatusBo status) {
        this.sender = sender;
        this.receivers = receivers;
        this.title = title;
        this.contents = contents;
        this.time = time;
        this.status = status;
    }

    public NotificationBo(Long id2, UserBo map, Set<UserBo> receivers2, String title2, String contents2,
			LocalDateTime time2, MessageStatus status2) {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserBo getSender() {
        return sender;
    }

    public void setSender(UserBo sender) {
        this.sender = sender;
    }

    public Set<UserBo> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<UserBo> receivers) {
        this.receivers = receivers;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public MessageStatusBo getStatus() {
        return status;
    }

    public void setStatus(MessageStatusBo status) {
        this.status = status;
    }
}
