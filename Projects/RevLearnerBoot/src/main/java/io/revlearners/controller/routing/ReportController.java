package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bo.ReportUserBo;

import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.REPORTS)
public class ReportController  extends WebServicesController {
	
	@GetMapping(WebConstants.GET_BY_ID)
	public ResponseEntity<ReportUserBo> getReportUserById(@PathVariable(value = "id") Long id) {
		ReportUserBo report = serviceFacade.getReportUserById(id);
		if(report == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(report);
	}
	
	@GetMapping(WebConstants.GET_LIST)
	public List<ReportUserBo> listTopics(Model model){
		return serviceFacade.listReportUsers();
	}
	
	@GetMapping(value = WebConstants.GET_PAGE, params = { "page", "size" })
	public Page<ReportUserBo> pageTopics(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
		return serviceFacade.pageReportUsers(page, size);
	}

}

