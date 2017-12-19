package io.revlearners.model.bean;

import javax.persistence.*;

import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name=Constants.TABLE_NOTIFICATION)
public class Notification implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6295517192344156314L;

	@Id
    @Column(name = Constants.COLUMN_NOTIFICATION_ID)
    @SequenceGenerator(name = "SEQ_GEN_NOTIFICATION", sequenceName = "SEQ_NOTIFICATION", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_GEN_NOTIFICATION")
    private Long id;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_SENDER_ID, referencedColumnName=Constants.COLUMN_USER_ID)
    private User sender;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_RECEIVER_ID, referencedColumnName=Constants.COLUMN_USER_ID)
    private User receiver;

    @Column(name=Constants.COLUMN_NOTIFICATION_TITLE)
    private String title;

    @Column(name=Constants.COLUMN_NOTIFICATION_CONTENTS)
    private String contents;

    @Column(name=Constants.COLUMN_NOTIFICATION_TIME)
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name=Constants.COLUMN_STATUS_ID)
    private MessageStatus status;

    public Notification() {
    }

    public Notification(User sender, User receiver, String title, String contents, LocalDateTime time, MessageStatus status) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.contents = contents;
        this.time = time;
        this.status = status;
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
