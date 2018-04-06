package test.ws.ws.persistence.repo;

import java.util.Collection;

import org.springframework.stereotype.Repository;

import test.ws.ws.persistence.model.Configuration;

public interface ConfigurationRepository extends IRepository<Configuration, Integer>{
	
	Collection<Configuration> getAllByOrganizationName(String organizationName);
	Configuration getOneByOrganizationNameAndKey(String organizationName, String nameProperty);
}
