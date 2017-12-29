package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Message;
import io.revlearners.model.services.interfaces.IMessageService;

@Service
public class MessageService extends CrudService<Message> implements IMessageService {

}
