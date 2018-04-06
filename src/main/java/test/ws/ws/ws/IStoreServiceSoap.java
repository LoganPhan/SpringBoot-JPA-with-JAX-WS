package test.ws.ws.ws;

import java.util.Collection;

import javax.jws.WebService;

import test.ws.ws.persistence.model.Configuration;

@WebService(targetNamespace = "http://store.service.soap.client.test.fulfillment.cifw")
public interface IStoreServiceSoap {
	
	Collection<Configuration> getAllConfig();
	
	Configuration create(Configuration config);
}
