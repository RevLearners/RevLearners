package io.revlearners.model.dao.interfaces;

import java.util.List;

import org.springframework.stereotype.Repository;

import io.revlearners.model.bean.Certification;
import io.revlearners.model.bean.UserCertification;

@Repository
public interface ICertificationRepository extends IBaseRepository<Certification> {
	
}
