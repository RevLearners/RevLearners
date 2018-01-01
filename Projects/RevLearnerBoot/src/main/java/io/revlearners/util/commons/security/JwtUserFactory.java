package io.revlearners.util.commons.security;

import java.util.LinkedList;
import java.util.List;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import io.revlearners.model.bo.UserBo;
import io.revlearners.util.commons.configs.Constants;

/**
 * This class was made in reference to the guide by Steven Zerhusen on basic JWT
 * token authentication
 */
public final class JwtUserFactory {

	private JwtUserFactory() {
	}

	public static JwtUser create(UserBo user) {
		return new JwtUser(user.getId(), user.getUsername(), user.getFirstName(), user.getMiddleName(),
				user.getLastName(), user.getEmail(), user.getPassword(), isEnabled(user), getAuthorities(user),
				user.getLastPasswordReset());
	}

	private static boolean isEnabled(UserBo user) {
		return user.getStatus().getId().equals(Constants.STATUS_OK);
	}

	// special permissions granted to user
	private static List<SimpleGrantedAuthority> getAuthorities(UserBo user) {
		List<SimpleGrantedAuthority> permissions = new LinkedList<SimpleGrantedAuthority>();
		for (String s : user.getPermissions()) {
			permissions.add(new SimpleGrantedAuthority(s));
		}
		return permissions;
	}
}
