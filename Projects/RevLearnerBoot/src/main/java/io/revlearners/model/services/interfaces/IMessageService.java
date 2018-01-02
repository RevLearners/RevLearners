package io.revlearners.model.services.interfaces;

import java.io.Serializable;
import java.util.List;

import io.revlearners.model.bean.Message;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.bo.MessageBo;

public interface IMessageService extends ICrudService<Message> {

	MessageStatus findOneStatus(Serializable messageStatusUnread);

	void updateStatus(List<Message> msgs);

	List<Message> findByReceiverId(Long id);

}
