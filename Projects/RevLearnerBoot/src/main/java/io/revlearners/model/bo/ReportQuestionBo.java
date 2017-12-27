package io.revlearners.model.bo;

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

public class ReportQuestionBo {

	private Long reportId;
	private QuestionBo question;
    private ReasonBo reason;
    private UserBo reporter;


	public ReportQuestionBo() {
	}

    public ReportQuestionBo(QuestionBo question, ReasonBo reason, UserBo reporter) {
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

    public QuestionBo getQuestion() {
        return question;
    }

    public void setQuestion(QuestionBo question) {
        this.question = question;
    }

    public ReasonBo getReason() {
        return reason;
    }

    public void setReason(ReasonBo reason) {
        this.reason = reason;
    }

    public UserBo getReporter() {
        return reporter;
    }

    public void setReporter(UserBo reporter) {
        this.reporter = reporter;
    }
}
