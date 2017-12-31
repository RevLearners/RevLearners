package io.revlearners.model.bo;

import javax.persistence.*;

import io.revlearners.model.bean.MessageStatus;
import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class MessageBo {

    private Long id;
    private UserBo sender;
    private Set<UserBo> receivers = new HashSet<UserBo>();
    private String title;
    private String contents;

    private Set<FileBlobBo> blobs = new LinkedHashSet<FileBlobBo>();
    private LocalDateTime time;
    private MessageStatusBo status;

    public void setBlobs(Set<FileBlobBo> blobs) {
        this.blobs = blobs;
    }

    public MessageBo(UserBo sender, Set<UserBo> receivers, String title, String contents, Set<FileBlobBo> blobs, LocalDateTime time, MessageStatusBo status) {
        this.sender = sender;
        this.receivers = receivers;
        this.title = title;
        this.contents = contents;
        this.blobs = blobs;
        this.time = time;
        this.status = status;
    }

    public MessageBo(UserBo sender, Set<UserBo> receivers, String title, String content, LocalDateTime time, MessageStatusBo status) {
        this.sender = sender;
        this.receivers = receivers;
        this.title = title;
        this.contents = content;
        this.time = time;
        this.status = status;
    }

    public MessageBo() {
    }

    public MessageBo(Long id2, UserBo map, Set<UserBo> receivers2, String title2, String contents2,
			Set<FileBlobBo> blobs2, LocalDateTime time2, MessageStatusBo status2) {
		// TODO Auto-generated constructor stub
    	this.id = id2;
    	this.sender = map;
    	this.receivers = receivers2;
    	this.title = title2;
    	this.contents = contents2;
    	this.blobs = blobs2;
    	this.time = time2;
    	this.status = status2;
	}

	@Override
	public String toString() {
		return "MessageBo [id=" + id + ", sender=" + sender + ", receivers=" + receivers + ", title=" + title
				+ ", contents=" + contents + ", blobs=" + blobs + ", time=" + time + ", status=" + status + "]";
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

    public Set<FileBlobBo> getBlobs() {
        return blobs;
    }

    public void setBlob(Set<FileBlobBo> blobs) {
        this.blobs = blobs;
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
