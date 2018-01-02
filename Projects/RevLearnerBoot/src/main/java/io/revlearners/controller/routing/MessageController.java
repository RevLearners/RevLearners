package io.revlearners.controller.routing;

import java.io.IOException;
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

import com.fasterxml.jackson.annotation.JsonView;

import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.jsonview.Views;
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
	public void createMessage(	@JsonView(Views.ToBackEnd.class) @RequestBody MessageBo message) throws IOException {
		serviceFacade.createMessages(message);
	}
	
	@PostMapping("/updateMessgaeStatus/{status}")
	public void updateStatus(@RequestBody List<MessageBo> messages) {
		//status updates persisted from front-end events
		serviceFacade.updateMessages(messages);
	}
	
	@GetMapping("/getAllMessages/{userid}")
	public @ResponseBody List<MessageBo> getAllMessagesByReceiverId(@PathVariable("userid") Long userId) {
		return serviceFacade.listMessagesByReceiverId(userId);
	}
	

}


