package io.revlearners.util.commons.security;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * This class was made in reference to the guide by Steven Zerhusen on basic JWT
 * token authentication
 */
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

	private final Log logger = LogFactory.getLog(this.getClass());

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private JwtToken jwtToken;

	@Value("${jwt.header}")
	private String tokenHeader;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {		String authToken = request.getHeader(this.tokenHeader);
		Enumeration<String> e = request.getHeaderNames();
		while (e.hasMoreElements()) {
			String s = e.nextElement();
			System.out.println(s + ": " + request.getHeader(s));
		}

		if (authToken != null && authToken.startsWith("Bearer ")) {
			authToken = authToken.substring(7);
		}

		String username = jwtToken.getUsernameFromToken(authToken);

		logger.info("checking authentication for user " + username);

		if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			// try to read details from token
			UserDetails userDetails = jwtToken.getUserDetails();

			// if null, we have to try getting from the database
			if (userDetails == null)
				userDetails = this.userDetailsService.loadUserByUsername(username);

			// validate token
			if (jwtToken.validateToken(authToken, userDetails)) {
				UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
						userDetails, null, userDetails.getAuthorities());
				authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				logger.info("authenticated user " + username + ", setting security context");
				SecurityContextHolder.getContext().setAuthentication(authentication);
			}
		}

		chain.doFilter(request, response);
	}
}