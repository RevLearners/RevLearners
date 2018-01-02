package io.revlearners.model.services;

import java.time.ZoneId;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.bo.MPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.mobile.device.Device;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import io.revlearners.util.commons.security.JwtToken;
import io.revlearners.util.commons.security.JwtUser;
import io.revlearners.util.commons.security.JwtUserFactory;

@Service
@Transactional
public class UserService extends CrudService<User> implements UserDetailsService, IUserService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtToken jwtTokenUtil;

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private IUserRepository userRepo;

	@Autowired
	private IUserStatusRepository statRepo;

	@Autowired
	private IUserRoleRepository roleRepo;

	@Autowired
	PasswordEncoder encoder;

	private UserDetails ud;
	private User user;

	private static final String USER_NOT_FOUND = "Invalid username";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userDao = userRepo.findByUsername(username);
		if (userDao == null)
			throw new UsernameNotFoundException(USER_NOT_FOUND);

		this.user = userDao;
        UserBo user = modelMapper.map(userDao, UserBo.class);
		ud = JwtUserFactory.create(user);
		return ud;
	}

	public String register(UserBo user, Device device) {
		UserStatus stat = statRepo.findOne(Constants.STATUS_PENDING);
		UserRole role = roleRepo.findOne(user.getRole().getId());
		String pass = encoder.encode(user.getPassword());

		User userEntity = new User(user.getFirstName(), user.getMiddleName(), user.getLastName(), stat, role,
				user.getEmail(), user.getUsername(), pass, Constants.START_DATE);
		userEntity.setRanks(new HashSet<>());
		for (Rank r : Constants.getBeginnerRanks()) {
			userEntity.getRanks().add(new UserRank(userEntity, r, 0f));
		}
		repository.saveAndFlush(userEntity);
		UserDetails userDetails = loadUserByUsername(user.getUsername());
		String token = jwtTokenUtil.generateToken(userDetails, device);
		System.out.println(jwtTokenUtil.getUsernameFromToken(token));
		return token;
	}

	@Override
	public MPair<User, String> login(String username, String password, Device device) {
		// Perform the security
		final Authentication authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		SecurityContextHolder.getContext().setAuthentication(authentication);

		// Load only once thanks to cached details
		final UserDetails userDetails = ud;
		// userDetailsService.loadUserByUsername(username);

		// return token
		String token = jwtTokenUtil.generateToken(userDetails, device);
		return new MPair<>(this.user, token);
	}

	@Override
	public String tryRefresh(String token) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
		JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);

		if (jwtTokenUtil.canTokenBeRefreshed(token, Date
				.from(user.getLastPasswordReset().toLocalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()))) {
			String refreshedToken = jwtTokenUtil.refreshToken(token);
			return refreshedToken;
		}
		return null;
	}

//	 we have a token, so we do not need to authenticate
//	just update and load user by username
	@Override
	public String verify(String token, Device device) {
		String username = jwtTokenUtil.getUsernameFromToken(token);
		User userDao = userRepo.findByUsername(username);
		userDao.setStatus(new UserStatus(Constants.STATUS_OK));
		this.update(userDao);
		UserDetails userDetails = this.loadUserByUsername(username);
		return jwtTokenUtil.generateToken(userDetails, device);
	}

    @Override
    public boolean userExists(String username) {
	    return userRepo.findByUsername(username) != null;
    } 
}
