package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name=Constants.TABLE_MESSAGE)
public class Message implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1952814977786579674L;

	@Id
    @Column(name = Constants.COLUMN_MESSAGE_ID)
    @SequenceGenerator(name = "SEQ_GEN_MESSAGE", sequenceName = "SEQ_MESSAGE", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_MESSAGE")
    private Long id;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_SENDER_ID, referencedColumnName=Constants.COLUMN_USER_ID)
    private User sender;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_RECEIVER_ID, referencedColumnName=Constants.COLUMN_USER_ID)
    private User receiver;

    @Column(name=Constants.COLUMN_MESSAGE_TITLE)
    private String title;

    @Column(name=Constants.COLUMN_MESSAGE_CONTENTS)
    private String contents;

    @OneToOne
    @JoinColumn(name=Constants.COLUMN_BLOB_ID)
    private FileBlob blob;

    @Column(name=Constants.COLUMN_MESSAGE_TIME)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_STATUS_ID)
    private MessageStatus status;


    public Message(User sender, User receiver, String title, String contents, FileBlob blob, LocalDateTime time, MessageStatus status) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.contents = contents;
        this.blob = blob;
        this.time = time;
        this.status = status;
    }

    public Message(User sender, User receiver, String title, String content, LocalDateTime time, MessageStatus status) {
        this.sender = sender;
        this.receiver = receiver;
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

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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

    public FileBlob getBlob() {
        return blob;
    }

    public void setBlob(FileBlob blob) {
        this.blob = blob;
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
