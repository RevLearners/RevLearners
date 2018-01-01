package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.services.interfaces.IUserRoleService;

@Service
public class RoleService extends CrudService<UserRole> implements IUserRoleService{

	@Override
	public UserRole findUserRole(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
