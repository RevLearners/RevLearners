package io.revlearners.model.bean;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="message")
public class Message {
    @Id
    @Column(name = "message_id")
    @SequenceGenerator(name = "seq_gen_message", sequenceName = "seq_message", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_message")
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User receiver;

    @Column(name="message_title")
    private String title;

    @Column(name="message_contents")
    private String contents;

    @ManyToOne       // or should this be one to one?
    @JoinColumn(name="blob_id")
    private FileBlob blob;

    @Column(name="message_time")
    private LocalDateTime time;

    @ManyToOne
    @JoinColumn(name="status_id")
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

    public Message(User sender, User receiver, String title, String contents, LocalDateTime time, MessageStatus status) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.contents = contents;
        this.time = time;
        this.status = status;
    }

    public Message() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
