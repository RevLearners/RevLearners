package io.revlearners.util.commons.security;

import io.revlearners.model.bo.UserBo;

public class JwtResponseObject {

	private String token;
	private UserBo user;
	
	public JwtResponseObject(String token, UserBo user) {
		this.token = token;
		this.user = user;
	}

	public String getToken() {
		return token;
	}

	public UserBo getUser() {
		return user;
	}
	
}
