package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bo.RankBo;
import io.revlearners.model.services.interfaces.IRankService;

@Service
public class RankService extends CrudService<Rank> implements IRankService {
}

