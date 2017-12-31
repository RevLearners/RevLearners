package io.revlearners.util.commons.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import io.revlearners.model.services.UserService;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.security.JwtAuthenticationEntryPoint;
import io.revlearners.util.commons.security.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
    @Bean
    public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationTokenFilter();
    }

	// This method is for overriding the default AuthenticationManagerBuilder.
	// We can specify how the user details are kept in the application. It may
	// be in a database, LDAP or in memory.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	// this configuration allow the client app to access the this api 
	// all the domain that consume this api must be included in the allowed o'rings 
	@Bean
	public WebMvcConfigurer corsConfigurer() {
	    return new WebMvcConfigurerAdapter() {
	        @Override
	        public void addCorsMappings(CorsRegistry registry) {
	        	
	        	// Allow CORS from Angular front-end
	            registry.addMapping("/**").allowedOrigins("http://localhost:4200");
	        }
	    };
	}

	// This method is for overriding some configuration of the WebSecurity
	// If you want to ignore some request or request patterns then you can
	// specify that inside this method
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/", "/resources/**", "/static/**", "/public/**", "/webui/**", "/h2-console/**"
	            , "/configuration/**", "/swagger-ui/**", "/swagger-resources/**", "/api-docs", "/api-docs/**", "/v2/api-docs/**"
	            , "/*.html", "/**/*.html" ,"/**/*.css","/**/*.js","/**/*.png","/**/*.jpg", "/**/*.gif", "/**/*.svg", "/**/*.ico", "/**/*.ttf","/**/*.woff");
	}

	// This method is used for override HttpSecurity of the web Application.
	// We can specify our authorization criteria inside this method.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		// starts authorizing configurations
		.authorizeRequests()
		// ignoring the guest's urls "
		.antMatchers("/create-account","/login","/logout", "/home", "/api/rest/**", "/auth", "/verify/*").permitAll()
		// authenticate all remaining URLS
		.anyRequest().authenticated().and().addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class)
		// configuring the session on the server
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
	      /* "/logout" will log the user out by invalidating the HTTP Session,
	       * cleaning up any {link rememberMe()} authentication that was configured, */
			.logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST")).and()
		// disabling the CSRF - Cross Site Request Forgery
		.csrf().disable();
	}


}
