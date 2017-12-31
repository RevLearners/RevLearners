package io.revlearners.model.services.interfaces;

import java.io.Serializable;

import io.revlearners.model.bean.Message;
import io.revlearners.model.bean.MessageStatus;

public interface IMessageService extends ICrudService<Message> {

	MessageStatus findOneStatus(Serializable messageStatusUnread);

}
