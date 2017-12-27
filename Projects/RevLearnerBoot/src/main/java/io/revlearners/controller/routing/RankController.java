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

import io.revlearners.model.bo.RankBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.RANKS)
public class RankController extends WebServicesController {
	
	@GetMapping(WebConstants.GET_BY_ID)
	public ResponseEntity<RankBo> getRankById(@PathVariable(value = "id") Long id) {
		RankBo rank = serviceFacade.getRankById(id);
		if(rank == null)
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok().body(rank);
	}
	
	@GetMapping(WebConstants.GET_LIST)
	public List<RankBo> listRanks(Model model){
		return serviceFacade.listRanks();
	}
	
	@GetMapping(value = WebConstants.GET_PAGE, params = { "page", "size" })
	public Page<RankBo> pageRanks(Model model, @RequestParam("page") int page, @RequestParam("size") int size){
		return serviceFacade.pageRanks(page, size);
	}
	
}
