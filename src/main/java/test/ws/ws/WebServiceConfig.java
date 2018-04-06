package test.ws.ws;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import test.ws.ws.ws.StoreServiceSoap;

@Configuration
@ComponentScan
public class WebServiceConfig {

	@Autowired
	private Bus bus;
	@Autowired
	private StoreServiceSoap storeServiceSoap;

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, storeServiceSoap);
		endpoint.publish("/");
		return endpoint;
	}

}