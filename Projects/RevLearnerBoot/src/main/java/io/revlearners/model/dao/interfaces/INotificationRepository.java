package io.revlearners.model.dao.interfaces;

import java.util.List;
import java.util.Set;

import io.revlearners.model.bean.Notification;

public interface INotificationRepository extends IBaseRepository<Notification> {

	/*
	 * if error bc passing in obj not managed by hibernate, i made a new user and just passed in user id 
	 * then just fetch user obj from db w id, and then pass into this method 
	 */
//	List<Notification> 
}

