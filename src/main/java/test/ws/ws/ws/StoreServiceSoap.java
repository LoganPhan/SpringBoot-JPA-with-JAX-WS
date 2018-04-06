package test.ws.ws.ws;

import java.util.Collection;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import test.ws.ws.persistence.model.Configuration;
import test.ws.ws.persistence.repo.ConfigurationRepository;

@WebService(endpointInterface = "test.ws.ws.ws.IStoreServiceSoap")
@Component
public class StoreServiceSoap implements IStoreServiceSoap {

	@Autowired
	ConfigurationRepository iConfigRepo;

	 public StoreServiceSoap() {
	        System.out.println("WS: WS bean instantiated!");
	 }

	@Override
	@WebMethod
	public Collection<Configuration> getAllConfig() {
		return iConfigRepo.getAll();
	}

	@Override
	public Configuration create(Configuration config) {
		return iConfigRepo.saveAndFlush(config);
	}
}
