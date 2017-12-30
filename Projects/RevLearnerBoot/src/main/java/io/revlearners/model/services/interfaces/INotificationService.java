package io.revlearners.model.services.interfaces;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

import io.revlearners.model.bean.Challenge;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.User;


public interface INotificationService extends ICrudService<Notification>{
	
	public Notification generateCertificationNotification(User sender, Set<User> receivers, MessageStatus status, String certName);
	
	public Notification generateAdvancementNotification(User sender, Set<User> receivers, MessageStatus status, String topic, String rankOld, String rankNew);
	
	public Notification generateChallengeNotification(User sender, Set<User> receivers, MessageStatus status, Challenge challenge);
    
	public List<Notification> getByUserId(User user);
    
	public void updateStatus(List<Notification> notifs); 
	
}
