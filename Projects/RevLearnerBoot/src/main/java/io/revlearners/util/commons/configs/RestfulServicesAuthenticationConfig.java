package io.revlearners.util.commons.configs;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class RestfulServicesAuthenticationConfig extends BasicAuthenticationEntryPoint {

	@Override
	public void commence (HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException{
		String header = String.format(WebConstants.WEB_REALM, getRealmName());
		response.addHeader(WebConstants.WWW_AUTHENTICATE, header);
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		setRealmName(WebConstants.REALM_NAME);
		super.afterPropertiesSet();
	}
}
