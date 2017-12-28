
package io.revlearners.model.services;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.Fetch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.User;

import io.revlearners.util.commons.configs.Constants;

public class NotificationService {
	@Autowired

	public Notification generateCertificationNotification(User user) {

		Notification notif = new Notification();
		LocalDateTime now = LocalDateTime.now();

		MessageStatus status = null;

		status.setName("unread");
		notif.setTitle("Certification Accepted");
		notif.setContents("Congratulations, " + user.getFirstName()
				+ "! Your certification has been verified. You have now been updated to an advanced user.");
		notif.setTime(now);
		notif.setStatus(status);
		
		return notif;

	}

	public Notification generateAdvancementNotification(User user) {

		Notification notif = new Notification();
		LocalDateTime now = LocalDateTime.now();
		MessageStatus status = new MessageStatus();
		status.setName("unread");

		notif.setTitle("Rank Advancement");
		notif.setContents("You have been updated from");
		notif.setTime(now);
		notif.setStatus(status);

		return notif;
	}

	public Notification generateChallengeNotification(Challenge challenge, User sender) {
		Transaction tx = null;

		Notification notif = new Notification();
		Set<User> receivers = challenge.getUsers();
		LocalDateTime now = LocalDateTime.now();
		MessageStatus status = new MessageStatus();
		status.setName("unread");

		notif.setSender(sender);
		notif.setReceivers(receivers);
		notif.setTitle("Challenge Issued!");
		notif.setContents("You have been issued a challenge by: " + sender);
		notif.setTime(now);
		notif.setStatus(status);

		return notif;
	}

	// public void pushToDB(Notification notif) {
	// //should be done by default upon creation?
	// }

	public Set<Notification> getByUserId(User user) {

		Set<Notification> table = null;

		return null;
	}

	public void updateStatus(Notification notif) {
		MessageStatus status = notif.getStatus();

	}

}
