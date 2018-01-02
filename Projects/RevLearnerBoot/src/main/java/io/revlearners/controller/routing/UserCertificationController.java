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

import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.bo.UserCertificationBo;
import io.revlearners.model.jsonview.Views;
import io.revlearners.util.commons.configs.WebConstants;

	@RestController
	@RequestMapping(WebConstants.USER_CERTIFICATIONS)
	public class UserCertificationController extends WebServicesController  {

		@GetMapping(WebConstants.GET_BY_ID)
		public ResponseEntity<CertificationBo> getMsgById(@PathVariable(value = "id") Long id) {
			CertificationBo msg = serviceFacade.getCertificationById(id);
			if(msg == null)
				return ResponseEntity.notFound().build();
			return ResponseEntity.ok().body(msg);
		}
		
		@GetMapping(WebConstants.GET_LIST)
		public List<CertificationBo> listRanks(Model model){
			return serviceFacade.listCertifications();
		}
		
		@GetMapping(value = WebConstants.GET_PAGE, params = { "page", "size" })
		public Page<CertificationBo> pageRanks(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
			return serviceFacade.pageCertifications(page, size);
		}
		
		@PostMapping("/create")
		public void createCertification(	@JsonView(Views.ToBackEnd.class) @RequestBody UserCertificationBo message) throws IOException {
			serviceFacade.createCertifications(message);
		}
		
		@GetMapping("/updateCertifications/{userid}/{certId}/{statId}")
		public @ResponseBody void updateCertificationById(@PathVariable("id") Long userId, @PathVariable("certId") Long certId, @PathVariable("statId") Long statId) {
			serviceFacade.updateUserCertification(userId, certId, statId);
		}
		
		@GetMapping("/getAllCertifications/{userid}")
		public @ResponseBody List<UserCertificationBo> getAllCertificationsByUserId(@PathVariable("userid") Long userId) {
			return serviceFacade.listCertificationsByUserId(userId);
		}
	}