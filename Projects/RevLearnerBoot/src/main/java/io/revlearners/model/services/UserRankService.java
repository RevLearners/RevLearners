package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.UserRank;
import io.revlearners.model.services.interfaces.IUserRankService;

@Service
public class UserRankService extends CrudService<UserRank> implements IUserRankService {

}
