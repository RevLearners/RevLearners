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

import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController extends WebServicesController {

    @Value("${jwt.header}")
    private String tokenHeader;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtToken jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private IUserService userService;


    @GetMapping(value = "verify/{userId}")  // todo: change to post when hitting from angular side
    public @ResponseBody
    Boolean verifyEmail(@PathVariable("userId") long userId) {
        User user = userService.findOne(userId);
        user.setStatus(new UserStatus(Constants.STATUS_OK));
        userService.update(user);
        System.out.println("=========================== verified! =================================");
        return true;
    }

    @PostMapping("/register")
    public void createUser(@RequestBody UserBo userCred) {
        userCred.setRoleId(Constants.ROLE_BASIC);
        serviceFacade.register(userCred);

        System.out.println(userCred);
    }

    @GetMapping("/userExist/{username}")
    public boolean userExist(@PathVariable(value = "username") String username) {
        List<UserBo> userList = serviceFacade.listUsers();

        //In case the list is empty, return false right away
        if (userList == null) {
            return false;
        }
        System.out.println("TAKE THE HIT 1: testingUsername: " + username);
        //Check through the list of users to see if anyone has the username
        //If taken, should return true right away
        for (UserBo u : userList) {
            System.out.println("TAKE THE HIT 2: Username:" + u.getUsername());
            if (u.getUsername().equals(username)) {
                System.out.println("TAKE THE HIT 3");
                return true;
            }
        }
        System.out.println("TAKE THE HIT 4");
        //If it's not taken, write false
        return false;
    }

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {

        // Perform the security
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Reload password post-security so we can generate token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails, device);

        // Return the token
        return ResponseEntity.ok(new JwtAuthenticationResponse(token));
    }

    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

        if (jwtTokenUtil.canTokenBeRefreshed(token, Date.from(user.getLastPasswordReset().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }

}