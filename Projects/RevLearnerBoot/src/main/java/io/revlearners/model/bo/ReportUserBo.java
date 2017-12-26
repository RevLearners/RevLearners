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

public class ReportUserBo {
	
	private Long id;
	private UserBo reported;
    private ReasonBo reason;
    private UserBo reporter;

	
	public ReportUserBo() {
	}

    public ReportUserBo(UserBo reported, ReasonBo reason, UserBo reporter) {
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

    public UserBo getReported() {
        return reported;
    }

    public void setReported(UserBo user) {
        this.reported = user;
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
