package io.revlearners.controller.routing;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.bo.RankBo;
import io.revlearners.model.bo.UserRoleBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.ROLE)
public class RoleController extends WebServicesController  {
	
//	@GetMapping(WebConstants.GET_BY_ID)
//	public ResponseEntity<UserRoleBo> getRoleById(@PathVariable(value = "id") Long id) {
//		UserRoleBo ur = serviceFacade.getRoleById(id);
//		if(ur == null)
//			return ResponseEntity.notFound().build();
//		return ResponseEntity.ok().body(ur);
//	}
	
	@GetMapping(WebConstants.GET_LIST)
	public List<UserRoleBo> listRoles(Model model){
		return serviceFacade.listRoles();
	}
	
	@GetMapping(WebConstants.GET_BY_ID)
	public ResponseEntity<UserRoleBo> getRoleByUserId(@PathVariable(value = "id") Long id) {
		UserRoleBo ur = serviceFacade.getRoleByUserId(id);
		if(ur == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(ur);
	}
	
	

}
