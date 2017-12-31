package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.MESSAGES)
public class MessageController extends WebServicesController  {

	@GetMapping(WebConstants.GET_BY_ID)
	public ResponseEntity<MessageBo> getMsgById(@PathVariable(value = "id") Long id) {
		MessageBo msg = serviceFacade.getMessageById(id);
		if(msg == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(msg);
	}
	
	@GetMapping(WebConstants.GET_LIST)
	public List<MessageBo> listRanks(Model model){
		return serviceFacade.listMessages();
	}
	
	@GetMapping(value = WebConstants.GET_PAGE, params = { "page", "size" })
	public Page<MessageBo> pageRanks(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
		return serviceFacade.pageMessages(page, size);
	}
	
	@PostMapping("/create")
	public void createMessage(@RequestBody MessageBo message) {
		//status updates persisted from front-end events
		serviceFacade.createMessage(message);
	}
	
	@PostMapping("/updateNotifStatus/{status}")
	public void updateStatus(@RequestBody List<NotificationBo> messages) {
		//status updates persisted from front-end events
		serviceFacade.updateNotification(messages);
	}
	
	@GetMapping("/getAllNotifications/{userid}")
	public @ResponseBody List<MessageBo> getAllMessagesById(@PathVariable("userid") Long userid) {
		return serviceFacade.listMessages();
	}
	

}


