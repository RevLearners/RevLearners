package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.services.interfaces.IChallengeService;

@Service
public class ChallengeService extends CrudService<Challenge> implements IChallengeService {

}
