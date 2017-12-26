package io.revlearners.model.services;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.services.dao.interfaces.contracts.IBeanService;
import io.revlearners.util.commons.configs.Constants;

public class RoleService {
    @Autowired
    protected SessionFactory sf;

    @Autowired
    @Qualifier(Constants.QUALIFY_BEAN_DAO_INJECTOR)
    protected IBeanService beanService;

    /**
     * returns a User's current role
     * @param user
     */
	public UserRole getRole(User user) {
	    UserRole role = user.getRole();
        return role;
	}
	
    /**
     * sets a User's role
     * @param user
     * @param
     */
	public void setRole(User user, UserRole role) {
	    user.setRole(role);
	}


}
