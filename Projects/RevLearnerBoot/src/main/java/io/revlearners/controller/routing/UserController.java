package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.model.bo.UserBo;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.USERS)
public class UserController  extends WebServicesController {
	
	@GetMapping("/userExist/{username}")
	public boolean userExist(@PathVariable(value = "username") String username) {
		List<UserBo> userList= serviceFacade.listUsers();
		
		//In case the list is empty, return false right away
		if(userList == null) {
			return false;
		}
		System.out.println("TAKE THE HIT 1: testingUsername: " + username);
		//Check through the list of users to see if anyone has the username
		//If taken, should return true right away
		for (UserBo u : userList) {
			System.out.println("TAKE THE HIT 2: Username:" + u.getUsername());
			if(u.getUsername().equals(username)) {
				System.out.println("TAKE THE HIT 3");
				return true;
			}
		}
		System.out.println("TAKE THE HIT 4");
		//If it's not taken, write false
		return false;
	}
	
	@PostMapping("/createUser")
	public void createUser(@RequestBody UserBo userCred) {
		userCred.setRoleId(Constants.ROLE_BASIC);
		serviceFacade.register(userCred);
		
		System.out.println(userCred);
	}
	

}
