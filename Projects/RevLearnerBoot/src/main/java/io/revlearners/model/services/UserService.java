package io.revlearners.model.services;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.model.bo.RankBo;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.bo.UserCertificationBo;
import io.revlearners.model.bo.UserRankBo;
import io.revlearners.model.dao.interfaces.IUserRepository;
import io.revlearners.model.dao.interfaces.IUserRoleRepository;
import io.revlearners.model.dao.interfaces.IUserStatusRepository;
import io.revlearners.model.services.interfaces.IUserService;
import io.revlearners.util.commons.configs.Constants;

@Service
@Transactional
public class UserService extends CrudService<User> implements UserDetailsService, IUserService {

	@Autowired
	private IUserRepository repository;
	
	@Autowired
	private IUserStatusRepository statRepo;
	
	@Autowired
	private IUserRoleRepository roleRepo;
	
	@Autowired
	PasswordEncoder encoder;
	
	private static final String USER_NOT_FOUND = "Invalid username";

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User userDao = repository.findByUsername(username);
		UserBo user = modelMapper.map(userDao, UserBo.class);
		if (user == null)
			throw new UsernameNotFoundException(USER_NOT_FOUND);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user));
	}
	
	// special permissions granted to user
	private List<SimpleGrantedAuthority> getAuthorities(UserBo user) {
		List<SimpleGrantedAuthority> permissions = new LinkedList<SimpleGrantedAuthority>();
		for(String s : user.getPermissions()) {
			permissions.add(new SimpleGrantedAuthority(s));
		}
		return permissions;
	}
	
	public UserBo register(UserBo user) {
		String pass;
		UserStatus stat = statRepo.findOne(Constants.STATUS_PENDING);
		UserRole role = roleRepo.findOne(user.getRoleId());
		pass = encoder.encode(user.getPassword());
		
		User userDao = new User(user.getFirstName(), user.getMiddleName(), user.getLastName(), 
				stat, role, user.getEmail(), user.getUsername(), pass);
		
		repository.saveAndFlush(userDao);
		
		return modelMapper.map(userDao, UserBo.class);
	}
}
