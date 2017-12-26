package io.revlearners.model.mapper.customConverters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.Message;
import io.revlearners.model.bean.User;
import io.revlearners.model.bo.FileBlobBo;
import io.revlearners.model.bo.MessageBo;
import io.revlearners.model.bo.UserBo;

@Component
public class MessageModelMapper extends ConverterConfigurerSupport<Message, MessageBo>{

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected Converter<Message, MessageBo> converter() {
		return new AbstractConverter<Message, MessageBo>() {

			@Override
			protected MessageBo convert(Message msg) {
				Set<UserBo> receivers = new LinkedHashSet<UserBo>();
				for(User u : msg.getReceivers()) {
					receivers.add(modelMapper.map(u, UserBo.class));
				}
				
				Set<FileBlobBo> blobs = new LinkedHashSet<FileBlobBo>();
				if(msg.getBlobs() != null) {
					for(FileBlob fb : msg.getBlobs()) {
						blobs.add(modelMapper.map(fb, FileBlobBo.class));
					}
				}
				
				return new MessageBo(msg.getId(), modelMapper.map(msg.getSender(), UserBo.class),
						receivers, msg.getTitle(), msg.getContents(), blobs,  msg.getTime(), msg.getStatus());
			}
			
		};
	}

}
