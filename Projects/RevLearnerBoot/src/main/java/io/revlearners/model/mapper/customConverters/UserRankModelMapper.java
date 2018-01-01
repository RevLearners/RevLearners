package io.revlearners.model.mapper.customConverters;

import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.UserRank;
import io.revlearners.model.bo.UserRankBo;

public class UserRankModelMapper extends ConverterConfigurerSupport<UserRank, UserRankBo> {

    @Override
    protected Converter<UserRank, UserRankBo> converter() {
        return new AbstractConverter<UserRank, UserRankBo>() {

            @Override
            protected UserRankBo convert(UserRank source) {
                return new UserRankBo(
                        source.getRank().getId(),
                        source.getRank().getName(),
                        source.getMerit(),
                        source.getRank().getTopic().getId(),
                        source.getRank().getTopic().getTopicName()
                );
            }
        };
    }
}
