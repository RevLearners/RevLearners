package io.revlearners.model.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import io.revlearners.util.commons.configs.Constants;

@Entity
@Table(name = Constants.TABLE_REPORT_USER)
public class ReportUser implements Serializable{
	
	private static final long serialVersionUID = 951458230310561236L;

	@Id
	@Column (name=Constants.COLUMN_REPORT_ID)
	@SequenceGenerator(sequenceName="REPORT_SEQ", name="REPORT_SEQ")
	@GeneratedValue(generator="REPORT_SEQ", strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_REPORTED_ID, referencedColumnName=Constants.COLUMN_USER_ID)
	private User reported;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_REASON_ID)
    private Reason reason;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name=Constants.COLUMN_REPORTER_ID, referencedColumnName=Constants.COLUMN_USER_ID)
    private User reporter;

	
	public ReportUser() {
	}

    public ReportUser(User reported, Reason reason, User reporter) {
        this.reported = reported;
        this.reason = reason;
        this.reporter = reporter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getReported() {
        return reported;
    }

    public void setReported(User user) {
        this.reported = user;
    }

    public Reason getReason() {
        return reason;
    }

    public void setReason(Reason reason) {
        this.reason = reason;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }
}
