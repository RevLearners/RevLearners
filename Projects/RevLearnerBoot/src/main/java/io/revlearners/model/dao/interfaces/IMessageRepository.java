package io.revlearners.model.dao.interfaces;

import java.util.List;

import io.revlearners.model.bean.Message;
import io.revlearners.model.bo.MessageBo;

public interface IMessageRepository extends IBaseRepository<Message> {

	List<Message> findMessageByReceiverId(Long id);

}
