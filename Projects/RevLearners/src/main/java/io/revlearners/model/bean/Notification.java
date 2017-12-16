package io.revlearners.model.bean;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="notification")
public class Notification {

    @Id
    @Column(name = "notification_id")
    @SequenceGenerator(name = "seq_gen_notification", sequenceName = "seq_notification", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_gen_notification")
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User receiver;

    @Column(name="notification_title")
    private String title;

    @Column(name="notification_contents")
    private String contents;

    @Column(name="notification_time")
    private LocalDateTime time;

    public Notification() {
    }

    public Notification(User sender, User receiver, String title, String contents, LocalDateTime time) {
        this.sender = sender;
        this.receiver = receiver;
        this.title = title;
        this.contents = contents;
        this.time = time;
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

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
