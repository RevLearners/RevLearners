//package io.revlearners.util.commons.security;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
//@Component
//public class UserAuthenticationProvider implements AuthenticationProvider {
//
//	@Override
//	public Authentication authenticate(Authentication auth) throws AuthenticationException {
//		
//		String name = auth.getName();
//		String password = auth.getCredentials().toString();
//		
//		if(shouldAuthenticateAgainstThirdPartySystem()) {
//			
//		}
//		return null;
//	}
//
//	@Override
//	public boolean supports(Class<?> arg0) {
//		return false;
//	}
//
//	
//}
