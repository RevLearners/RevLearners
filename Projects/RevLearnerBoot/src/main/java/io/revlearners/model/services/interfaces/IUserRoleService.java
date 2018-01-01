package io.revlearners.model.services.interfaces;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;

public interface IUserRoleService extends ICrudService<UserRole>{

	UserRole findUserRole(User user);

}
