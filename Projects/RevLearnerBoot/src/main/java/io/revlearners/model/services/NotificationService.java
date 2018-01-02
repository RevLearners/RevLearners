package io.revlearners.model.services;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.User;
import io.revlearners.model.services.interfaces.INotificationService;
/*
 * This class generates notifications based on 
 */
@Service
public class NotificationService extends CrudService<Notification> implements INotificationService {

	NotificationService persist;

	// Generate certification notification
	public void generateCertificationNotification(User sender, Set<User> receivers, MessageStatus status,
			String certName) {

		createAll(sender, receivers, "Certification Accepted",
				"Congratulations, " + receivers.iterator().next().getUsername() + "! Your " + certName
						+ " certification has been verified. You have now been upgraded to an advanced user.",
				status);
	}

	 // system is sender

	// Generate rank advancement notification
	public void generateAdvancementNotification(User sender, Set<User> receivers, MessageStatus status,
			String topic, String rankOld, String rankNew) {

		createAll(sender, receivers, "Rank Advancement", "Good job!\n" + receivers.iterator().next().getUsername()
				+ "! You have been upgraded from" + rankOld + " to " + rankNew + " in " + topic + ".", status);
	} // system is sender

	// Generate challenge notification
	public void generateChallengeNotification(User sender, Set<User> receivers, MessageStatus status,
			Challenge challenge) {

		createAll(sender, receivers, "Challenge Issued!",
				"You have been issued a challenge by: " + sender.getUsername() + "!", status);
	} // user is sender

	public List<Notification> getByUserId(User user) {
		List<Notification> allNotifs = persist.findAll();
		Long id = user.getId();

		for (Notification nb : allNotifs) {
			if (nb.getSender().getId() != id)
				allNotifs.remove(nb);
		}

		return allNotifs;
	}

	public void updateStatus(List<Notification> notifs) {
		for (Notification n : notifs) {
			update(n);
		}
	}

	private void createAll(User sender, Set<User> receivers, String title, String contents, MessageStatus status) {
		List<Notification> notifs = new LinkedList<Notification>();
				
		for(User u : receivers) {
			Set<User> cc = new HashSet<User>(receivers);
			cc.remove(u);
			notifs.add(new Notification(sender, u, cc, title, contents, LocalDateTime.now(), status));
		}
		
		create(notifs);
	}
}

// how to test it works?
// how to persist to DB
// create notification bo obj to persist it, populate THIS w my data,
// create w crud service creat method