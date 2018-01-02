package io.revlearners.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Certification;
import io.revlearners.model.bean.RequestStatus;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.dao.interfaces.ICertificationRepository;
import io.revlearners.model.dao.interfaces.IRequestStatusRepository;
import io.revlearners.model.dao.interfaces.IUserCertificationRepository;
import io.revlearners.model.services.interfaces.IUserCertificationService;

@Service
public class UserCertificationService extends CrudService<UserCertification> implements IUserCertificationService {

	@Autowired
	private IUserCertificationRepository repository;
	
	@Autowired
	private ICertificationRepository certRepo;

	@Autowired
	private IRequestStatusRepository reqRepo;

	@Override
	public Certification findCert(Long certId) {
		return certRepo.findOne(certId);
	}

	@Override
	public RequestStatus findRequest(Long reqId) {
		return reqRepo.findOne(reqId);
	}

	@Override
	public List<Certification> listCertifications() {
		return certRepo.findAll();
	}

	@Override
	public Page<Certification> pageCerts(int page, int size) {
		return certRepo.findAll(new PageRequest(page, size));
	}

}
