package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.ReportUser;
import io.revlearners.model.services.interfaces.IReportUserService;

@Service
public class ReportUserService extends CrudService<ReportUser> implements IReportUserService {

}
