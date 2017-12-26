package io.revlearners.model.mapper.customConverters;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Question;
import io.revlearners.model.bean.QuestionOption;
import io.revlearners.model.bo.QuestionBo;
import io.revlearners.model.bo.QuestionOptionBo;

@Component
public class QuestionModelMapper extends ConverterConfigurerSupport<Question, QuestionBo> {

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	protected Converter<Question, QuestionBo> converter() {
		return new AbstractConverter<Question, QuestionBo>(){

			@Override
			protected QuestionBo convert(Question quest) {
				Set<QuestionOptionBo> options = new HashSet<QuestionOptionBo>();
				QuestionOptionBo answer = null;
				for(QuestionOption qo : quest.getOptions()) {
					QuestionOptionBo qBo = modelMapper.map(qo, QuestionOptionBo.class);
					options.add(qBo);
					if(qo.isCorrect()) {
						answer = qBo;
					}
				}
				
				double score = quest.getDifficulty().getMultiplier() * quest.getType().getBaseVal();
								
				return new QuestionBo(quest.getId(), quest.getText(), quest.getTopic().getTopicName(), quest.getDifficulty().getName(), 
						quest.getType().getName(), answer, quest.getExplanation(), score, options);
			}
		};
	}
	
}
