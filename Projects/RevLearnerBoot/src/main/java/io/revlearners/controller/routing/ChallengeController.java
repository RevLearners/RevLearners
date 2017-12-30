package io.revlearners.controller.routing;

import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bo.ChallengeBo;
import io.revlearners.util.commons.configs.WebConstants;

@RestController
@RequestMapping(WebConstants.CHALLENGES)
public class ChallengeController extends WebServicesController {
	
	@GetMapping("/getChallenges")
	@Produces(MediaType.APPLICATION_JSON)
	public List<ChallengeBo> getChallengesById(){
		List<ChallengeBo> challenges = serviceFacade.listChallenges();
		
		
		return challenges;
	}
	

}
