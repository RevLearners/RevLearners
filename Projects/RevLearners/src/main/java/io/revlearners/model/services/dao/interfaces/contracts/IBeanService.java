package io.revlearners.model.services.dao.interfaces.contracts;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import io.revlearners.util.persistence.interfaces.IGenericDao;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public interface IBeanService extends IGenericDao {

}
