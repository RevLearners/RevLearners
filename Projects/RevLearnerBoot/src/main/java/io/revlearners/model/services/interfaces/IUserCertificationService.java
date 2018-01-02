package io.revlearners.model.services.interfaces;

import java.util.List;

import org.springframework.data.domain.Page;

import io.revlearners.model.bean.Certification;
import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.bean.RequestStatus;
import io.revlearners.model.bean.User;;

public interface IUserCertificationService extends ICrudService<UserCertification> {
	
	Certification findCert(Long certId);

	RequestStatus findRequest(Long requestStatusPending);
	
	List<Certification> listCertifications();

	Page<Certification> pageCerts(int page, int size);

}
