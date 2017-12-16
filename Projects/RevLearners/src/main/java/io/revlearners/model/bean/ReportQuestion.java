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

@Entity
@Table(name = "REPORT_QUESTION")
public class ReportQuestion implements Serializable{
	
	@Id
	@Column (name="REPORT_ID")
	@SequenceGenerator(sequenceName="REPORT_SEQ", name="REPORT_SEQ")
	@GeneratedValue(generator="REPORT_SEQ", strategy=GenerationType.SEQUENCE)
	private int reportId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "QUESTION_ID")
	private int questionId;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "REASON_ID")
	private int reasonId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private int reporterId;

	

	public int getReporterId() {
		return reporterId;
	}

	public void setReporterId(int reporterId) {
		this.reporterId = reporterId;
	}

	public ReportQuestion(int reportId, int questionId, int reasonId, int reporterId) {
		super();
		this.reportId = reportId;
		this.questionId = questionId;
		this.reasonId = reasonId;
		this.reporterId = reporterId;
	}

	public ReportQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public int getReasonId() {
		return reasonId;
	}

	public void setReasonId(int reasonId) {
		this.reasonId = reasonId;
	}
	
	
}
