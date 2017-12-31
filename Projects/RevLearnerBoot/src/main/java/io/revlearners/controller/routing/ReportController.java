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
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bo.ReportQuestionBo;
import io.revlearners.model.bo.ReportUserBo;

import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.REPORTS)
public class ReportController  extends WebServicesController {
	
	private static final String USERS = "/users";
	private static final String QUESTIONS = "/questions";
	
	@GetMapping(USERS + WebConstants.GET_BY_ID)
	public ResponseEntity<ReportUserBo> getReportUserById(@PathVariable(value = "id") Long id) {
		ReportUserBo report = serviceFacade.getReportUserById(id);
		if(report == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(report);
	}
	
	@GetMapping(USERS + WebConstants.GET_LIST)
	public List<ReportUserBo> listUserReports(Model model){
		return serviceFacade.listReportUsers();
	}
	
	@GetMapping(value = USERS + WebConstants.GET_PAGE, params = { "page", "size" })
	public Page<ReportUserBo> pageUserReports(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
		return serviceFacade.pageReportUsers(page, size);
	}
	
	@PostMapping(USERS + WebConstants.CREATE)
	public void createUserReport(@RequestBody ReportUserBo report) {
		serviceFacade.createReportUser(report);
	}
	
	@PostMapping(USERS + WebConstants.UPDATE_BY_ID)
	public void updateUserReport(@RequestBody ReportUserBo report) {
		serviceFacade.updateReportUser(report);
	}

	@GetMapping(QUESTIONS + WebConstants.GET_BY_ID)
	public ResponseEntity<ReportUserBo> getReportQuestionById(@PathVariable(value = "id") Long id) {
		ReportUserBo report = serviceFacade.getReportUserById(id);
		if(report == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(report);
	}
	
	@GetMapping(QUESTIONS + WebConstants.GET_LIST)
	public List<ReportUserBo> listReportQuestions(Model model){
		return serviceFacade.listReportUsers();
	}
	
	@GetMapping(value = QUESTIONS + WebConstants.GET_PAGE, params = { "page", "size" })
	public Page<ReportUserBo> pageReportQuestions(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
		return serviceFacade.pageReportUsers(page, size);
	}
	
	@PostMapping(QUESTIONS + WebConstants.CREATE)
	public void createUserReport(@RequestBody ReportQuestionBo report) {
		serviceFacade.createReportQuestion(report);
	}
	
	@PostMapping(QUESTIONS + WebConstants.UPDATE_BY_ID)
	public void updateReport(@RequestBody ReportQuestionBo report) {
		serviceFacade.updateReportQuestion(report);
	}
}

