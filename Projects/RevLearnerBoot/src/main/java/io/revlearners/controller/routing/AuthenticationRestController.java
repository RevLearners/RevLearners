package io.revlearners.controller.routing;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.configs.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import io.revlearners.util.commons.security.JwtAuthenticationRequest;
import io.revlearners.util.commons.security.JwtAuthenticationResponse;
import io.revlearners.util.commons.security.JwtToken;
import io.revlearners.util.commons.security.JwtUser;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController extends WebServicesController {

	@Value("${jwt.header}")
	private String tokenHeader;

	@Autowired
    private IUserService userService;

	@GetMapping(value = "verify", params = "token")
	public @ResponseBody Boolean verifyEmail(@RequestParam("token") String token, Device device) throws UnsupportedEncodingException {
		String decodedToken = URLDecoder.decode(token, "UTF-8");
		serviceFacade.verifyUser(decodedToken, device);
		System.out.println("=========================== verified! =================================");
		return true;
	}

    @GetMapping("/userExist/{username}")
    public boolean userExist(@PathVariable(value = "username") String username) {
        System.out.println("TAKE THE HIT 1: testingUsername: " + username);
        return userService.userExists(username);
    }

	@PostMapping("/register")
	public ResponseEntity<?> createUser(@RequestBody UserBo userCred, Device device) {
		userCred.setRoleId(Constants.ROLE_BASIC);
		serviceFacade.register(userCred, device);

		System.out.println(userCred);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
			Device device) throws AuthenticationException {
		String token;

		token = serviceFacade.login(authenticationRequest.getUsername(), authenticationRequest.getPassword(), device);

		return ResponseEntity.ok(new JwtAuthenticationResponse(token));
	}

	@RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
	public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
		String token = request.getHeader(tokenHeader);
		String refreshedToken = serviceFacade.checkRefresh(token);
		if (refreshedToken != null) {
			return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
		} else {
			return ResponseEntity.badRequest().body(null);
		}
	}

}