package io.revlearners.model.services;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import io.revlearners.model.bean.User;
import io.revlearners.model.bo.RankBo;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.bo.UserCertificationBo;
import io.revlearners.model.bo.UserRankBo;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.configs.Constants;

@Service
public class UserService extends CrudService<User, UserBo> implements UserDetailsService, IUserService {

	private static final String USER_NOT_FOUND = "Invalid username";

	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		UserBo user = this.findOne(Long.parseLong(userId));
		if (user == null)
			throw new UsernameNotFoundException(USER_NOT_FOUND);
		return new org.springframework.security.core.userdetails.User(user.getId().toString(), user.getPassword(),
				getAuthorities(user));
	}

	// Determine user permissions by topic, role
	private void getAdvRoles(UserBo user, List<SimpleGrantedAuthority> permissions) {
		for (UserRankBo rank : user.getRanks()) {
			if (rank.getMerit() > Constants.ADV_USER_PTS)
				permissions.add(new SimpleGrantedAuthority(Constants.ROLE_ADVANCED_STR + "_" + rank.getTopic()));
		}
	}

	// Determine user permissions by topic, role
	private void getCertRoles(UserBo user, List<SimpleGrantedAuthority> permissions) {
		for (UserCertificationBo cert : user.getCertifications()) {
			if (cert.getStatus().equals(Constants.REQUEST_STATUS_APPROVED_STR))
				permissions.add(new SimpleGrantedAuthority(Constants.ROLE_ADVANCED_STR + "_" + cert.getTopic()));
		}
	}

	// special permissions granted to user
	private List<SimpleGrantedAuthority> getAuthorities(UserBo user) {
		List<SimpleGrantedAuthority> permissions = new LinkedList<SimpleGrantedAuthority>();
		// add basic user and admin permissions
		if (user.getRole().equals(Constants.ROLE_BASIC_STR) || user.getRole().equals(Constants.ROLE_ADMIN_STR))
			permissions.add(new SimpleGrantedAuthority(user.getRole()));
		// add advances and certifications
		getAdvRoles(user, permissions);
		getCertRoles(user, permissions);
		return permissions;
	}
}
