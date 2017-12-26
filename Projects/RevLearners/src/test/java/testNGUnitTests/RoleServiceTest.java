package testNGUnitTests;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bean.User;
import io.revlearners.model.bean.UserRank;
import io.revlearners.model.bean.UserRole;
import io.revlearners.model.bean.UserStatus;
import io.revlearners.util.commons.configs.Constants;
import preTestScripts.DBInit;

public class RoleServiceTest extends PersistenceLayerTest{

	private Session session;

	User userBasic = null;
	User userAdvanced = null;
	User userCertified = null;
	User userAdmin = null;

	@BeforeClass
	public final void before() {
		DBInit.create(sf);
		session = sf.openSession();
	}

	@AfterClass
	public final void after() {
		session.close();
	}
	
	@Test(priority = 1)
	public void userInsertTest() {
		Set<Topic> topics;
		Rank rank;
		UserRank utr;

		topics = new HashSet<Topic>(service.fetchAllSubTypes(Topic.class, session));
		UserStatus us = service.fetchSubTypeById(UserStatus.class, Constants.STATUS_PENDING, session);
		
		UserRole urBasic = service.fetchSubTypeById(UserRole.class, Constants.ROLE_BASIC, session);
		userBasic = new User("John", "Basic", "Doe", us, urBasic, "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		
		UserRole urAdvanced = service.fetchSubTypeById(UserRole.class, Constants.ROLE_ADVANCED, session);
		userAdvanced = new User("John", "Advanced", "Doe", us, urAdvanced, "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		
		UserRole urCertified = service.fetchSubTypeById(UserRole.class, Constants.ROLE_CERTIFIED, session);
		userCertified = new User("John", "Certified", "Doe", us, urCertified, "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		
		UserRole urAdmin = service.fetchSubTypeById(UserRole.class, Constants.ROLE_ADMIN, session);
		userAdmin = new User("John", "Admin", "Doe", us, urAdmin, "mail@email.com", "aUsername", "password",
				"this is a salt, a really bad salt, but a salt none the less");
		
		session.beginTransaction();
		service.create(userBasic, session);
		service.create(userAdvanced, session);
		service.create(userCertified, session);
		service.create(userAdmin, session);
		session.getTransaction().commit();
	}
	
	@Test(dependsOnMethods = "userInsertTest")
	public void verifyRole() {
		if(userBasic.getRole().getId() == 1) {
			System.out.println("basic works");
		}
		if(userAdvanced.getRole().getId() == 2) {
			System.out.println("advanced works");
		}
		if(userCertified.getRole().getId() == 3) {
			System.out.println("certified works");
		}
		if(userAdmin.getRole().getId() == 4) {
			System.out.println("admin works");
		}		
	}

	
}
