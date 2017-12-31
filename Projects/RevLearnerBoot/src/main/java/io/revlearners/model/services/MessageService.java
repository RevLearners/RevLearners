package io.revlearners.model.services;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Message;
import io.revlearners.model.bean.MessageStatus;
import io.revlearners.model.dao.interfaces.IMessageStatusRepository;
import io.revlearners.model.services.interfaces.IMessageService;

@Service
public class MessageService extends CrudService<Message> implements IMessageService {

	@Autowired
	private IMessageStatusRepository msgRepo;
	
	@Override
	public MessageStatus findOneStatus(Serializable id) {
		return msgRepo.findOne(id);
	}

}
