package io.revlearners.model.mapper.customConverters;

import java.util.*;

import io.revlearners.model.bean.*;
import io.revlearners.model.bo.*;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.jmnarloch.spring.boot.modelmapper.ConverterConfigurerSupport;

import io.revlearners.util.commons.configs.Constants;

@Component
public class UserModelMapper extends ConverterConfigurerSupport<User, UserBo> {

    @Autowired
    ModelMapper modelMapper;

    private UserConverter c = new UserConverter();

    @Override
    protected Converter<User, UserBo> converter() {
        return c;
    }

    // Determine user permissions by topic, role
    private void getAdvRoles(User user, Set<String> permissions) {
        if (user.getRanks() != null)
            for (UserRank rank : user.getRanks()) {
                if (rank.getMerit() > Constants.ADV_USER_PTS)
                    permissions.add(Constants.ROLE_ADVANCED_STR + "_" + rank.getRank().getTopic().getTopicName());
            }
    }

    // Determine user permissions by topic, role
    private void getCertRoles(User user, Set<String> permissions) {
        if (user.getCertifications() != null)
            for (UserCertification cert : user.getCertifications()) {
                if (cert.getStatus().equals(Constants.REQUEST_STATUS_APPROVED_STR))
                    permissions
                            .add(Constants.ROLE_ADVANCED_STR + "_" + cert.getCertification().getTopic().getTopicName());
            }
    }

    public UserBo map(User u, Class<UserBo> bo) {
        return c.convert(u);
    }

    private class UserConverter extends AbstractConverter<User, UserBo> {

        @Override
        protected UserBo convert(User user) {

            Set<String> permissions = new LinkedHashSet<>();

            // get mappers for nontrivial conversions
            Set<UserRankBo> ranks = new LinkedHashSet<>();
            for (UserRank r : user.getRanks()) {
                ranks.add(modelMapper.map(r.getRank(), UserRankBo.class));
            }

            permissions.add(user.getRole().getName());
            getAdvRoles(user, permissions);
            getCertRoles(user, permissions);

            UserRoleBo role = modelMapper.map(user.getRole(), UserRoleBo.class);
            UserStatusBo status = modelMapper.map(user.getStatus(), UserStatusBo.class);

            return new UserBo(user.getId(), user.getFirstName(), user.getMiddleName(), user.getLastName(),
                    user.getEmail(), user.getUsername(), user.getPassword(), user.getLastPasswordReset(),
                    status, role, ranks, permissions);
        }
    }

}
