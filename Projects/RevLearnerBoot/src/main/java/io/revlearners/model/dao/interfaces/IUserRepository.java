package io.revlearners.model.dao.interfaces;

import io.revlearners.model.bean.User;

public interface IUserRepository extends IBaseRepository<User> {

	User findByUsername(String username);
}
