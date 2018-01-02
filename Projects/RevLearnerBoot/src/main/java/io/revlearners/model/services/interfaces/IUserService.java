package io.revlearners.model.services.interfaces;

import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.bo.MPair;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.mobile.device.Device;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.bo.UserBo;

public interface IUserService extends ICrudService<User> {

	public String register(UserBo user, Device device);

	public MPair<User, String> login(String username, String password, Device device);

	public String tryRefresh(String token);

	public String verify(String token, Device device);

	boolean userExists(String username);

}
