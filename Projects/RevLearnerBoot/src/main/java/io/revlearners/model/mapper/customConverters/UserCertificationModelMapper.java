package io.revlearners.model.mapper.customConverters;

import org.modelmapper.AbstractConverter;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.bo.UserCertificationBo;

@Component
public class UserCertificationModelMapper extends ConverterConfigurerSupport<UserCertification, UserCertificationBo> {

	@Override
	protected AbstractConverter<UserCertification, UserCertificationBo> converter() {
		return new AbstractConverter<UserCertification, UserCertificationBo>() {

			@Override
			protected UserCertificationBo convert(UserCertification source) {
				return new UserCertificationBo(source.getCertification().getId(), source.getCertification().getName(),
						source.getCertification().getTopic().getTopicName(), source.getStatus().getName());
			}
		};
	}
}
