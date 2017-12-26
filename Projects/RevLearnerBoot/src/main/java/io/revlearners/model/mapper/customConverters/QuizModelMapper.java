package io.revlearners.model.mapper.customConverters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.Quiz;
import io.revlearners.model.bo.QuestionBo;
import io.revlearners.model.bo.QuizBo;

@Component
public class QuizModelMapper extends ConverterConfigurerSupport<Quiz, QuizBo>{

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected Converter<Quiz, QuizBo> converter() {
		return new AbstractConverter<Quiz, QuizBo>() {

			@Override
			protected QuizBo convert(Quiz quiz) {
				Set<QuestionBo> questions = new  LinkedHashSet<QuestionBo>();
				for(Question q : quiz.getQuestions()) {
					questions.add(modelMapper.map(q, QuestionBo.class));
				}
				
				
				return new QuizBo(quiz.getId(), quiz.getTime(), questions);
			}
			
		};
	}
	
}
