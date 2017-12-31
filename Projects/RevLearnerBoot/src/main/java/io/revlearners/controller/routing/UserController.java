package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bo.UserBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.USERS)
public class UserController  extends WebServicesController {

	@GetMapping(WebConstants.GET_LIST)
	public List<UserBo> getUserList(){
		System.out.println("EY YOOOOOOOOOOOO!");
		
		return serviceFacade.listUsers();
	}
}
