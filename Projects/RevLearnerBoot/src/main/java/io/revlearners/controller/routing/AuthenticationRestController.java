package io.revlearners.controller.routing;

import io.revlearners.model.bean.UserRole;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.bo.LoginInfoBo;
import io.revlearners.model.bo.UserRoleBo;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.configs.Constants;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import io.revlearners.util.commons.security.JwtAuthenticationRequest;
import io.revlearners.util.commons.security.JwtAuthenticationResponse;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;

@RestController
public class AuthenticationRestController extends WebServicesController {

    @Autowired
    IUserService userService;

    @Value("${jwt.header}")
    private String tokenHeader;

    @PostMapping(value = "/verify")
    public @ResponseBody
    Boolean verifyEmail(@RequestBody String token, Device device) throws UnsupportedEncodingException {
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
        userCred.setRole(new UserRoleBo(Constants.ROLE_BASIC, Constants.ROLE_BASIC_STR));
        serviceFacade.register(userCred, device);

        System.out.println(userCred);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "${jwt.route.authentication.path}", method = RequestMethod.POST)
    public ResponseEntity<LoginInfoBo> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest,
                                                                 Device device) throws AuthenticationException {
        try {
            LoginInfoBo loginInfo = serviceFacade.login(authenticationRequest.getUsername(), authenticationRequest.getPassword(), device);
            return ResponseEntity.ok(loginInfo);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
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