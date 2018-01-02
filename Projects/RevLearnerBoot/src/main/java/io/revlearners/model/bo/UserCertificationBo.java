
package io.revlearners.model.bo;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.Constants;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserCertificationBo {

	@JsonView(Views.ToFrontEnd.class)
	private String name;

	@JsonView(Views.ToBackEnd.class)
	private List<String> names;

	@JsonView(Views.ToBackEnd.class)
	private List<String> topics;
	
	@JsonView(Views.ToFrontEnd.class)
	private String topic;

	@JsonView(Views.ToFrontEnd.class)
	private String status;

	@JsonView(Views.ToFrontEnd.class)
	private UserBo user;
	
	@JsonView(Views.ToFrontEnd.class)
	private CertificationBo cert;

	public CertificationBo getCert() {
		return cert;
	}

	public void setCert(CertificationBo cert) {
		this.cert = cert;
	}

	@JsonView(Views.ToBackEnd.class)
	private Long certId;
	
	public List<String> getTopics() {
		return topics;
	}

	public void setTopics(List<String> topics) {
		this.topics = topics;
	}

	public Long getCertId() {
		return certId;
	}

	public void setCertId(Long certId) {
		this.certId = certId;
	}

	@JsonView(Views.ToBackEnd.class)
	private Long id;

	@JsonView(Views.ToFrontEnd.class)
	private Long reqId;
	
	public Long getReqId() {
		return reqId;
	}

	public void setReqId(Long reqId) {
		this.reqId = reqId;
	}

	public List<FileBlobBo> getBlobs() {
		return blobs;
	}

	public void setBlobs(List<FileBlobBo> blobs) {
		this.blobs = blobs;
	}

	@JsonView(Views.ToBackEnd.class)
	private List<MultipartFile> files;

	@JsonView(Views.ToFrontEnd.class)
	private List<FileBlobBo> blobs;

	public UserBo getUser() {
		return user;
	}

	public void setUser(UserBo user) {
		this.user = user;
	}

	public Long getUserId() {
		return id;
	}

	public void setUserId(Long id) {
		this.id = id;
	}

	public UserCertificationBo() {
	}

	// input
	public UserCertificationBo(List<String> names, List<String> topics, String status, Long id, Long certId, List<MultipartFile> files) {
		this.names = names;
		this.topics = topics;
		this.status = status;
		this.files = files;
		this.id = id;
		this.certId = certId;
	}
	
	// output
	public UserCertificationBo(CertificationBo cert, UserBo user, Long reqId, String reqName, List<FileBlobBo> blobs) {
		this.user = user;
		this.cert = cert;
		this.reqId = reqId;
		this.status = reqName;
		this.blobs = blobs;
	}

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}
}
