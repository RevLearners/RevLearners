package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bean.Notification;
import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.NOTIFICATIONS)
public class NotificationController extends WebServicesController  {

	@GetMapping(WebConstants.GET_BY_ID)
	public ResponseEntity<NotificationBo> getMsgById(@PathVariable(value = "id") Long id) {
		NotificationBo note = serviceFacade.getNotificationById(id);
		if(note == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(note);
	}
	
	@GetMapping(WebConstants.GET_LIST)
	public List<NotificationBo> listNotifications(Model model){
		System.out.println("TEstn\n\n\n\n\n\n\"");
		return serviceFacade.listNotifications();
	}
	
	
	
	@PostMapping("/updateNotifStatus/{status}")
	public void updateStatus(@RequestBody List<NotificationBo> notifs) {
		//status updates persisted from front-end events
		serviceFacade.updateNotification(notifs);
	}
	
	@GetMapping("/getAllNotifications/{userid}")
	public @ResponseBody List<NotificationBo> getAllNotifsById(@PathVariable("userid") Long userid) {
//		List<NotificationBo> allUserNotifs = null;
//		serviceFacade.get
		return serviceFacade.listNotifications();
	}
	
}
