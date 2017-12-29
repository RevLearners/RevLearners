package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.ReportQuestion;
import io.revlearners.model.services.interfaces.IReportQuestionService;

@Service
public class ReportQuestionService extends CrudService<ReportQuestion> implements IReportQuestionService {

}
