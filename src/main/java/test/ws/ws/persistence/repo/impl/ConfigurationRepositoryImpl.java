package test.ws.ws.persistence.repo.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import test.ws.ws.persistence.model.Configuration;
import test.ws.ws.persistence.repo.ConfigurationRepository;

/**
 * <p>The abstract repository which implements common APIs of a repository.</p>
 * @author LoganPhan
 * @see {@link Repository}
 */
@Repository
public class ConfigurationRepositoryImpl extends IRepositoryImpl<Configuration, Integer> implements ConfigurationRepository {
	
	protected Logger LOG = LoggerFactory.getLogger(ConfigurationRepositoryImpl.class);

	@Override
	public Collection<Configuration> getAllByOrganizationName(String organizationName) {
		LOG.info("Excute getAllByOrganizationName ");
		Collection<Configuration> allConf = null;
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Configuration> query = cb.createQuery(Configuration.class);
			Root<Configuration> root = query.from(Configuration.class);
			allConf = getEntityManager().createQuery(query).getResultList();
			LOG.info("Done Excute getAllByOrganizationName");
			if(allConf.isEmpty()){
				LOG.info(String.format("%s with retryflag not found", organizationName));
			}
		} catch (PersistenceException e) {
			LOG.warn("List<AllFlow> getAllByOrganizationName throw exception", e);
		}
		return allConf;
	}
	
	@Override
	public Configuration getOneByOrganizationNameAndKey(String organizationName, String nameProperty) {
		LOG.info("Excute getOneByOrganizationNameAndKey");
		List<Configuration> configs = null;
		try {
			CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
			CriteriaQuery<Configuration> query = cb.createQuery(Configuration.class);
			Root<Configuration> root = query.from(Configuration.class);
			configs = getEntityManager().createQuery(query).getResultList();
			LOG.info("Done Excute getOneByOrganizationNameAndKey");
			if(configs.isEmpty()){
				LOG.info(String.format("%s with retryflag not found", organizationName));
				return null;
			}
		} catch (PersistenceException e) {
			LOG.warn("List<AllFlow> getOneByOrganizationNameAndKey throw exception", e);
			return null;
		}
		return configs.get(0);
	}
	
}
