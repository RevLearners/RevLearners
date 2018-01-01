package io.revlearners.model.mapper.customConverters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Notification;
import io.revlearners.model.bean.User;
import io.revlearners.model.bo.MessageStatusBo;
import io.revlearners.model.bo.NotificationBo;
import io.revlearners.model.bo.UserBo;

@Component
public class NotificationModelMapper extends ConverterConfigurerSupport<Notification, NotificationBo>{

	@Autowired
	UserModelMapper userModelMapper;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected Converter<Notification, NotificationBo> converter() {
		return new AbstractConverter<Notification, NotificationBo>(){

			@Override
			protected NotificationBo convert(Notification notif) {
				Set<UserBo> receivers = new LinkedHashSet<UserBo>();
				for(User u : notif.getReceivers()) {
					receivers.add(modelMapper.map(u, UserBo.class));
				}
				
				return new NotificationBo(notif.getId(), modelMapper.map(notif.getSender(), UserBo.class),
						receivers, notif.getTitle(), notif.getContents(), notif.getTime(), modelMapper.map(notif.getStatus(), MessageStatusBo.class));
			}
			
		};
	}
}
