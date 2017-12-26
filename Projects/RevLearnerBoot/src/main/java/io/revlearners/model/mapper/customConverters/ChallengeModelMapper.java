package io.revlearners.model.mapper.customConverters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.User;
import io.revlearners.model.bo.ChallengeAttemptBo;
import io.revlearners.model.bo.ChallengeBo;
import io.revlearners.model.bo.QuizBo;
import io.revlearners.model.bo.UserBo;

@Component
public class ChallengeModelMapper extends ConverterConfigurerSupport<Challenge, ChallengeBo> {

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected Converter<Challenge, ChallengeBo> converter() {
		return new AbstractConverter<Challenge, ChallengeBo>(){
			
			@Override
			protected ChallengeBo convert(Challenge chal) {
				Set<ChallengeAttemptBo> attempts = new LinkedHashSet<ChallengeAttemptBo>();
				for(ChallengeAttempt ca : chal.getAttempts()) {
					attempts.add(modelMapper.map(ca, ChallengeAttemptBo.class));
				}
				
				Set<UserBo> users = new LinkedHashSet<UserBo>();
				for(User u : chal.getUsers()) {
					users.add(modelMapper.map(u, UserBo.class));
				}
				
				return new ChallengeBo(chal.getId(), modelMapper.map(chal.getQuiz(), QuizBo.class), attempts, users);
			}
			
		};
	}
	

}
