package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bean.Notification;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.NOTIFICATIONS)
public class NotificationController extends WebServicesController  {

	@PostMapping("/updateNotifStatus/{status}")
	public void updateStatus(@RequestBody List<NotificationBo> notifs) {
		//status updates persisted from front-end events
		serviceFacade.updateNotification(notifs);
	}
	
	@GetMapping("/getAllNotifications/{userid}")
	public @ResponseBody List<NotificationBo> getAllNotifsById(@PathVariable("userid") Long userid) {
		List<NotificationBo> allUserNotifs = null;
//		serviceFacade.get
		
		return allUserNotifs;
	}
	
}
