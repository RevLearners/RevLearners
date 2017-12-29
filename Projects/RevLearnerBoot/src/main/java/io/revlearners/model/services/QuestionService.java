package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Question;
import io.revlearners.model.services.interfaces.IQuestionService;

@Service
public class QuestionService extends CrudService<Question> implements IQuestionService {

}
