package io.revlearners.model.mapper.customConverters;

import java.util.LinkedHashSet;
import java.util.Set;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bean.Topic;
import io.revlearners.model.bo.RankBo;
import io.revlearners.model.bo.TopicBo;

@Component
public class TopicModelMapper extends ConverterConfigurerSupport<Topic, TopicBo> {
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	protected Converter<Topic, TopicBo> converter() {
		return new AbstractConverter<Topic, TopicBo>(){

			@Override
			protected TopicBo convert(Topic topic) {
				Set<RankBo> ranks = new LinkedHashSet<RankBo>();
				for(Rank r : topic.getRanks()) {
					ranks.add(modelMapper.map(r, RankBo.class));
				}
				
				return new TopicBo(topic.getId(), topic.getTopicName(), ranks);
			}
		};
	}
	
	

}
