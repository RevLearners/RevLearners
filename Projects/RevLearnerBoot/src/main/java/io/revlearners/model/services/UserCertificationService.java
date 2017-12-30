package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.services.interfaces.IUserCertificationService;

@Service
public class UserCertificationService extends CrudService<UserCertification> implements IUserCertificationService {

}
