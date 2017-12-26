package io.revlearners.controller.routing;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bo.TopicBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.TOPICS)
public class TopicController extends WebServicesController {
	
	@GetMapping("/getOne/{id}")
	public ResponseEntity<TopicBo> getTopicById(@PathVariable(value = "id") Long id) {
		TopicBo topic = serviceFacade.getTopicById(id);
		if(topic == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(topic);
	}
	
	@GetMapping("/listTopics")
	public List<TopicBo> listTopics(Model model){
		return serviceFacade.listTopics();
	}
	
	@GetMapping(value = "/getPages/", params = { "page", "size" })
	public Page<TopicBo> pageTopics(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
		return serviceFacade.pageTopics(page, size);
	}
	
}
