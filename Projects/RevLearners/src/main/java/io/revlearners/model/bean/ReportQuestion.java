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
@Table(name = Constants.TABLE_REPORT_QUESTION)
public class ReportQuestion implements Serializable{

	private static final long serialVersionUID = -2629022365581051748L;

	@Id
	@Column (name=Constants.COLUMN_REPORT_ID)
	@SequenceGenerator(sequenceName="REPORT_SEQ", name="REPORT_SEQ")
	@GeneratedValue(generator="REPORT_SEQ", strategy=GenerationType.SEQUENCE)
	private Long reportId;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_QUESTION_ID)
	private Question question;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = Constants.COLUMN_REASON_ID)
    private Reason reason;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name=Constants.COLUMN_USER_ID)
    private User reporter;


	public ReportQuestion() {
	}

    public ReportQuestion(Question question, Reason reason, User reporter) {
        this.question = question;
        this.reason = reason;
        this.reporter = reporter;
    }

    public Long getReportId() {
        return reportId;
    }

    public void setReportId(Long reportId) {
        this.reportId = reportId;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
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
