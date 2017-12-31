package io.revlearners.controller.routing;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.USERS)
public class UserController  extends WebServicesController {

}
