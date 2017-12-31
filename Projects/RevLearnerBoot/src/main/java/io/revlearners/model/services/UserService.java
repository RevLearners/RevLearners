package io.revlearners.model.services;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRank;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.dao.interfaces.IUserRepository;
import io.revlearners.model.dao.interfaces.IUserRoleRepository;
import io.revlearners.model.dao.interfaces.IUserStatusRepository;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.configs.Constants;
import io.revlearners.util.commons.security.JwtUserFactory;

@Service
@Transactional
public class UserService extends CrudService<User> implements UserDetailsService, IUserService {

    @Autowired
    EmailService emailService;

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IUserStatusRepository statRepo;

	@Autowired
	private IUserRoleRepository roleRepo;

	@Autowired
	PasswordEncoder encoder;

	private static final String USER_NOT_FOUND = "Invalid username";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userDao = userRepo.findByUsername(username);
		UserBo user = modelMapper.map(userDao, UserBo.class);
		if (user == null)
			throw new UsernameNotFoundException(USER_NOT_FOUND);
		return JwtUserFactory.create(user);
	}

	public UserBo register(UserBo user) {
		UserStatus stat = statRepo.findOne(Constants.STATUS_PENDING);
		UserRole role = roleRepo.findOne(user.getRoleId());
		String pass = encoder.encode(user.getPassword());

		User userEntity = new User(user.getFirstName(), user.getMiddleName(), user.getLastName(), stat, role,
				user.getEmail(), user.getUsername(), pass, Constants.START_DATE);
		userEntity.setRanks(new HashSet<>());
		for(Rank r : Constants.getBeginnerRanks()) {
			userEntity.getRanks().add(new UserRank(userEntity, r, 0L));
		}
		userRepo.saveAndFlush(userEntity);
		emailService.sendVerificationEmail(userEntity.getEmail(), userEntity.getId());

		return modelMapper.map(userEntity, UserBo.class);
	}

    @Override
    public boolean userExists(String username) {
	    return userRepo.findByUsername(username) != null;
    }
}
