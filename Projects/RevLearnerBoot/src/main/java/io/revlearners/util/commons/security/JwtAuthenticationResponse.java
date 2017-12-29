package io.revlearners.util.commons.security;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 3314269487510384790L;

	private final String token;

    public JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return this.token;
    }
}