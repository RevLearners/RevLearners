package io.revlearners.controller.routing;

import com.fasterxml.jackson.annotation.JsonView;
import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.ChallengeAttempt;
import io.revlearners.model.bean.Question;
import io.revlearners.model.bo.ChallengeAttemptBo2;
import io.revlearners.model.bo.ChallengeInfoBo;
import io.revlearners.model.jsonview.Views;
import org.springframework.web.bind.annotation.*;

import io.revlearners.util.commons.configs.WebConstants;

import java.util.List;

/**
 * todo: verify that logged in user has access
 */
@RestController
@RequestMapping(WebConstants.CHALLENGES)
public class ChallengeController extends WebServicesController {

    @GetMapping("/getChallenge/{challengeId}")
    public @JsonView(Views.ToFrontEnd.class)
    Challenge getChallenge(@PathVariable("challengeId") long id) {
        return serviceFacade.getChallengeById(id);
    }

    @PostMapping("createChallenge")
    @JsonView(Views.ToFrontEnd.class)
    public @ResponseBody
    Challenge createChallenge(@JsonView(Views.ToBackEnd.class) @RequestBody ChallengeInfoBo info) {
        return serviceFacade.generateChallenge(info);
    }

    @PostMapping("createQuestion")
    public @JsonView(Views.ToFrontEnd.class)
    Question addQuestion(@JsonView(Views.ToBackEnd.class) @RequestBody Question question) {
        return serviceFacade.createQuestion(question);
    }

    /**
     * handle request to get all a user's challenges
     *
     * @param id
     * @return
     */
    @GetMapping("getChallengeById/{id}")
    public @JsonView(Views.ToFrontEnd.class) Challenge getChallengeById(@PathVariable long id) {
        return serviceFacade.getChallengeById(id);
    }

    /**
     * handle request to get all a user's challenges
     *
     * @param userId
     * @return
     */
    @GetMapping("getChallengesByUser/{userId}")
    public @JsonView(Views.ToFrontEnd.class)
    List<Challenge> getChallengesByUser(@PathVariable long userId) {
        return serviceFacade.getChallengesByUser(userId);
    }

    /**
     * handle request to get all a user's attempts for a challenge
     *
     * @param userId
     * @return
     */
    @GetMapping("getChallengeAttempts/{userId}/{challengeId}")
    public @JsonView(Views.ToFrontEnd.class)
    List<ChallengeAttempt> getAttemptsByUser(@PathVariable("userId") long userId, @PathVariable("challengeId") long challengeId) {
        return serviceFacade.getChallengeAttemptsByUser(userId, challengeId);
    }

    @PostMapping("createAttempt")
    public Float submitAttempt(@RequestBody ChallengeAttemptBo2 attemptInfo) {
        return serviceFacade.scoreChallenge(attemptInfo);
    }
}
