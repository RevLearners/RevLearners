package io.revlearners.model.mapper.customConverters;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.bean.UserRank;
import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.bo.ChallengeAttemptBo;
import io.revlearners.model.bo.ChallengeBo;
import io.revlearners.model.bo.RankBo;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.bo.UserCertificationBo;
import io.revlearners.model.bo.UserRankBo;

@Component
public class UserModelMapper extends ConverterConfigurerSupport<User, UserBo>{

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected Converter<User, UserBo> converter() {
		
		return new AbstractConverter<User, UserBo>() {

			@Override
			protected UserBo convert(User user) {
				
				
				// get mappers for nontrivial conversions
				Set<UserRankBo> ranks = new LinkedHashSet<UserRankBo>();
				for(UserRank r : user.getRanks()) {
					ranks.add(modelMapper.map(r.getRank(), UserRankBo.class));
				}
				
				Set<UserCertificationBo> certs = new LinkedHashSet<UserCertificationBo>();
				for(UserCertification uc : user.getCertifications()) {
					certs.add(modelMapper.map(uc.getCertification(), UserCertificationBo.class));
				}
				
				Set<ChallengeAttemptBo> chalAttempts = new LinkedHashSet<ChallengeAttemptBo>();
				for(ChallengeAttempt ca : user.getChallengeAttempts()) {
					chalAttempts.add(modelMapper.map(ca, ChallengeAttemptBo.class));
				}
				
				Set<ChallengeBo> challenges = new LinkedHashSet<ChallengeBo>();
				for(Challenge c : user.getChallenges()) {
					challenges.add(modelMapper.map(c, ChallengeBo.class));
				}

				// we must manually create users
				Set<UserBo> friends = new LinkedHashSet<UserBo>();
				for(User u : user.getFriends()) {
					friends.add(modelMapper.map(u, UserBo.class));
				}
				
				return new UserBo(user.getId(), user.getFirstName(), user.getMiddleName(), user.getLastName(),
							user.getEmail(), user.getUsername(), user.getRole().getId(), user.getRole().getName(),
							user.getStatus().getId(), user.getStatus().getName(), ranks, certs, chalAttempts, challenges, friends);
			}
		};
	}

}
