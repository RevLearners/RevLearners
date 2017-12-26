package io.revlearners.model.services;

import org.springframework.stereotype.Service;

import io.revlearners.model.bean.Topic;
import io.revlearners.model.bo.TopicBo;
import io.revlearners.model.services.interfaces.ITopicService;

@Service
public class TopicService extends CrudService<Topic, TopicBo> implements ITopicService {

	
}
