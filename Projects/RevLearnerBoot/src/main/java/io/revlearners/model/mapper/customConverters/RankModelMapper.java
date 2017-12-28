package io.revlearners.model.mapper.customConverters;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.Rank;
import io.revlearners.model.bo.RankBo;

//@Component
public class RankModelMapper extends ConverterConfigurerSupport<Rank, RankBo>{
	
	@Override
	protected Converter<Rank, RankBo> converter() {
		return new AbstractConverter<Rank, RankBo>() {

			@Override
			protected RankBo convert(Rank rank) {
				
				return new RankBo(rank.getId(), rank.getName(), rank.getTopic().getId(), rank.getTopic().getTopicName(), rank.getRelativeWeight(), rank.getMeritThreshold());
			}
			
		};
	}

}
