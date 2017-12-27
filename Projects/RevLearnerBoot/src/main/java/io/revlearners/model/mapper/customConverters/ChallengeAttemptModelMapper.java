package io.revlearners.model.mapper.customConverters;

import java.util.HashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.QuestionOption;
import io.revlearners.model.bo.ChallengeAttemptBo;
import io.revlearners.model.bo.QuestionOptionBo;
import io.revlearners.model.bo.UserBo;

@Component
public class ChallengeAttemptModelMapper extends ConverterConfigurerSupport<ChallengeAttempt, ChallengeAttemptBo> {

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected Converter<ChallengeAttempt, ChallengeAttemptBo> converter() {
		return new AbstractConverter<ChallengeAttempt, ChallengeAttemptBo>(){

			@Override
			protected ChallengeAttemptBo convert(ChallengeAttempt ca) {
				Set<QuestionOptionBo> answers = new HashSet<QuestionOptionBo>();
				for(QuestionOption qo : ca.getAnswers()) {
					answers.add(modelMapper.map(qo, QuestionOptionBo.class));
				}
				
				return new ChallengeAttemptBo(ca.getId(), modelMapper.map(ca.getUser(), UserBo.class), answers);
			}
		};
	}
}
