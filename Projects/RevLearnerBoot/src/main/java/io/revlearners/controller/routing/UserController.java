package io.revlearners.controller.routing;

import java.util.List;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.interfaces.IServiceFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.model.bo.UserBo;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
// @RequestMapping(WebConstants.USERS)
public class UserController extends WebServicesController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IServiceFacade facade;


    @PostMapping("/register")
    public void createUser(@RequestBody UserBo userCred) {
        userCred.setRoleId(Constants.ROLE_BASIC);
        facade.register(userCred);

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


    @GetMapping(value = "/verify/{userId}")
    public @ResponseBody
    Boolean verifyEmail(@PathVariable("userId") long userId) {
        User user = userService.findOne(userId);
        user.setStatus(new UserStatus(Constants.STATUS_OK));
        userService.update(user);
        System.out.println("=========================== verified! =================================");
        return true;
    }

}
