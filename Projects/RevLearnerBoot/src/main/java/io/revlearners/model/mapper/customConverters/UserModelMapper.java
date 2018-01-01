package io.revlearners.model.mapper.customConverters;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
import io.revlearners.util.commons.configs.Constants;

@Component
public class UserModelMapper extends ConverterConfigurerSupport<User, UserBo> {

	@Autowired
	ModelMapper modelMapper;

	private UserConverter c = new UserConverter();

	@Override
	protected Converter<User, UserBo> converter() {
		return c;
	}

	// Determine user permissions by topic, role
	private void getAdvRoles(User user, Set<String> permissions) {
		if (user.getRanks() != null)
			for (UserRank rank : user.getRanks()) {
				if (rank.getMerit() > Constants.ADV_USER_PTS)
					permissions.add(Constants.ROLE_ADVANCED_STR + "_" + rank.getRank().getTopic().getTopicName());
			}
	}

	// Determine user permissions by topic, role
	private void getCertRoles(User user, Set<String> permissions) {
		if (user.getCertifications() != null)
			for (UserCertification cert : user.getCertifications()) {
				if (cert.getStatus().equals(Constants.REQUEST_STATUS_APPROVED_STR))
					permissions
							.add(Constants.ROLE_ADVANCED_STR + "_" + cert.getCertification().getTopic().getTopicName());
			}
	}

	public UserBo map(User u, Class<UserBo> bo) {
		return c.convert(u);
	}

	private class UserConverter extends AbstractConverter<User, UserBo> {
				
		@Override
		protected UserBo convert(User user) {

			Set<String> permissions = new LinkedHashSet<String>();

			// get mappers for nontrivial conversions
			Set<UserRankBo> ranks = new LinkedHashSet<UserRankBo>();
			for (UserRank r : user.getRanks()) {
				ranks.add(modelMapper.map(r.getRank(), UserRankBo.class));
			}

			Set<UserCertificationBo> certs = new LinkedHashSet<UserCertificationBo>();
			if (user.getCertifications() != null)
				for (UserCertification uc : user.getCertifications()) {
					certs.add(modelMapper.map(uc.getCertification(), UserCertificationBo.class));
				}

			Set<ChallengeAttemptBo> chalAttempts = new LinkedHashSet<ChallengeAttemptBo>();
			if (user.getChallengeAttempts() != null)
				for (ChallengeAttempt ca : user.getChallengeAttempts()) {
					chalAttempts.add(modelMapper.map(ca, ChallengeAttemptBo.class));
				}

			Set<ChallengeBo> challenges = new LinkedHashSet<ChallengeBo>();
			if (user.getChallenges() != null)
				for (Challenge c : user.getChallenges()) {
					challenges.add(modelMapper.map(c, ChallengeBo.class));
				}

			// we must manually create users
			Set<Long> friends = new LinkedHashSet<Long>();
			if (user.getFriends() != null)
				for (User u : user.getFriends()) {
					u.getId();
				}

			permissions.add(user.getRole().getName());
			getAdvRoles(user, permissions);
			getCertRoles(user, permissions);

			return new UserBo(user.getId(), user.getFirstName(), user.getMiddleName(), user.getLastName(),
					user.getEmail(), user.getUsername(), user.getPassword(), user.getLastPasswordReset(),
					user.getRole().getId(), user.getRole().getName(), user.getStatus().getId(),
					user.getStatus().getName(), ranks, certs, chalAttempts, challenges, friends, permissions);
		}
	}

}
