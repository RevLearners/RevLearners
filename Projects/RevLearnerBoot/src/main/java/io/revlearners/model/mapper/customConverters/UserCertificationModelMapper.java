package io.revlearners.model.mapper.customConverters;

import java.util.LinkedList;
import java.util.List;

import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.model.bean.FileBlob;
import io.revlearners.model.bean.UserCertification;
import io.revlearners.model.bo.CertificationBo;
import io.revlearners.model.bo.FileBlobBo;
import io.revlearners.model.bo.UserBo;
import io.revlearners.model.bo.UserCertificationBo;

@Component
public class UserCertificationModelMapper extends ConverterConfigurerSupport<UserCertification, UserCertificationBo> {

	@Autowired
	ModelMapper modelMapper;
	
	@Override
	protected AbstractConverter<UserCertification, UserCertificationBo> converter() {
		return new AbstractConverter<UserCertification, UserCertificationBo>() {

			@Override
			protected UserCertificationBo convert(UserCertification source) {
				List<FileBlobBo> blobs = new LinkedList<FileBlobBo>();
				for(FileBlob blob : source.getBlobs()) {
					blobs.add(modelMapper.map(blob, FileBlobBo.class));
				}
				
				
				return new UserCertificationBo(modelMapper.map(source.getCertification(), CertificationBo.class), 
						modelMapper.map(source.getUser(), UserBo.class),
						source.getStatus().getId(), source.getStatus().getName(), blobs);
			}
		};
	}
}
