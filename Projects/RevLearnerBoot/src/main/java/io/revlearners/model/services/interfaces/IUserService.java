package io.revlearners.model.services.interfaces;

import org.springframework.mobile.device.Device;

import io.revlearners.model.bean.User;
import io.revlearners.model.bo.UserBo;

public interface IUserService extends ICrudService<User> {

	public String register(UserBo user, Device device);

	public String login(String username, String password, Device device);

	public String tryRefresh(String token);

	public String verify(String token, Device device);

}
