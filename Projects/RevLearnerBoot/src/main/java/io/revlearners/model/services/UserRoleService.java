package io.revlearners.model.services;

import org.springframework.beans.factory.annotation.Autowired;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.dao.interfaces.IUserRepository;
import io.revlearners.model.dao.interfaces.IUserRoleRepository;
import io.revlearners.model.services.interfaces.IUserRoleService;

public class UserRoleService extends CrudService<UserRole> implements IUserRoleService {

	@Autowired
    IUserRoleRepository userRankRepo;

    @Autowired
    IUserRepository userRepo;

	@Override
	public UserRole findUserRole(User user) {
		// TODO Auto-generated method stub
		return null;
	}
    

}
