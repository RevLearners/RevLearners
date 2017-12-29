
package io.revlearners.model.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.User;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.model.services.interfaces.INotificationService;


//how to test it works?
//how to persist to DB
//create notification bo obj to persist it, populate THIS w my data, 
//create w crud service creat method
public class NotificationService extends CrudService<Notification, NotificationBo> implements INotificationService{
	
	NotificationService persist;
	
	//Generate certification notification 
	public Notification generateCertificationNotification(User sender, Set<User> receivers, MessageStatus status, String certName) {
		Notification notif = new Notification();
		LocalDateTime now = LocalDateTime.now();
		
		notif.setSender(sender);
		notif.setReceivers(receivers);
		notif.setTitle("Certification Accepted");
		notif.setContents("Congratulations, " + receivers.iterator().next().getUsername() + "! Your " + certName + " certification has been verified. You have now been updated to an advanced user.");
		notif.setTime(now);
		notif.setStatus(status);
		
		return notif;		
	}	//system is sender
	
	//Generate rank advancement notification 
	public Notification generateAdvancementNotification(User sender, Set<User> receivers, MessageStatus status, String topic, String rankOld, String rankNew) {
		Notification notif = new Notification();
		LocalDateTime now = LocalDateTime.now();
		
		notif.setSender(sender);
		notif.setReceivers(receivers);
		notif.setTitle("Rank Advancement");
		notif.setContents("Good job, " + receivers.iterator().next().getUsername() + "! You have been upgraded from" + rankOld + " to " + rankNew + " in " + topic + "!");
		notif.setTime(now);
		notif.setStatus(status);

		return notif;
	} //system is sender

	//Generate challenge notification
	public Notification generateChallengeNotification(User sender, Set<User> receivers, MessageStatus status, Challenge challenge) {
		Notification notif = new Notification();
		LocalDateTime now = LocalDateTime.now();
		
		notif.setSender(sender);
		notif.setReceivers(receivers);
		notif.setTitle("Challenge Issued!");
		notif.setContents("You have been issued a challenge by: " + sender.getUsername() + "!");
		notif.setTime(now);
		notif.setStatus(status);

		return notif;
	} //user is sender

	public List<NotificationBo> getByUserId(User user) {
		List<NotificationBo> allNotifs = persist.findAll();
		Long id = user.getId();
		
		for (NotificationBo nb : allNotifs) { if (nb.getSender().getId() != id) allNotifs.remove(nb); }

		return allNotifs;
	}

	public void updateStatus(Notification notif, MessageStatus update) {
		notif.setStatus(update);
	}

}
