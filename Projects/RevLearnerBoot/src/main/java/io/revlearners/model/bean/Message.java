package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = Constants.TABLE_MESSAGE)
public class Message implements Serializable {

    private static final long serialVersionUID = -1952814977786579674L;

    @Id
    @Column(name = Constants.COLUMN_MESSAGE_ID)
    @SequenceGenerator(name = "SEQ_GEN_MESSAGE", sequenceName = "SEQ_MESSAGE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_MESSAGE")
    private Long id;

    @Override
	public String toString() {
		return "Message [id=" + id + ", sender=" + sender + ", receivers=" + receivers + ", title=" + title
				+ ", contents=" + contents + ", blobs=" + blobs + ", time=" + time + ", status=" + status + "]";
	}

	@ManyToOne
    @JoinColumn(name = Constants.COLUMN_SENDER_ID, referencedColumnName = Constants.COLUMN_USER_ID)
    private User sender;
	
	@ManyToOne
    @JoinColumn(name = Constants.COLUMN_RECEIVER_ID, referencedColumnName = Constants.COLUMN_USER_ID)
    private User receiver;

    @ManyToMany
    @JoinTable(name = Constants.TABLE_MESSAGE_RECEIVER, joinColumns = @JoinColumn(name = Constants.COLUMN_MESSAGE_ID), inverseJoinColumns = @JoinColumn(name = Constants.COLUMN_USER_ID))
    private Set<User> receivers = new HashSet<User>();

    @Column(name = Constants.COLUMN_MESSAGE_TITLE)
    private String title;

    @Column(name = Constants.COLUMN_MESSAGE_CONTENTS)
    private String contents;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = Constants.TABLE_MESSAGE_ATTACHMENT,
            joinColumns = @JoinColumn(name = Constants.COLUMN_MESSAGE_ID),
            inverseJoinColumns = @JoinColumn(name = Constants.COLUMN_BLOB_ID)
    )
    private Set<FileBlob> blobs = new LinkedHashSet<FileBlob>();

    @Column(name = Constants.COLUMN_MESSAGE_TIME)
    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = Constants.COLUMN_STATUS_ID)
    private MessageStatus status;


    public void setBlobs(Set<FileBlob> blobs) {
        this.blobs = blobs;
    }

    public Message(User sender, User receiver, Set<User> receivers, String title, String contents, Set<FileBlob> blobs, LocalDateTime time, MessageStatus status) {
        this.sender = sender;
        this.receivers = receivers;
        this.title = title;
        this.contents = contents;
        this.blobs = blobs;
        this.time = time;
        this.status = status;
    }

    public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public Message(User sender, Set<User> receivers, String title, String content, LocalDateTime time, MessageStatus status) {
        this.sender = sender;
        this.receivers = receivers;
        this.title = title;
        this.contents = content;
        this.time = time;
        this.status = status;
    }

    public Message() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Set<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<User> receivers) {
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

    public Set<FileBlob> getBlobs() {
        return blobs;
    }

    public void setBlob(Set<FileBlob> blobs) {
        this.blobs = blobs;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public MessageStatus getStatus() {
        return status;
    }

    public void setStatus(MessageStatus status) {
        this.status = status;
    }

}
