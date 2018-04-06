package test.ws.ws;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;

import test.ws.ws.ws.StoreServiceSoap;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "test.ws.ws.persistence.repo.impl", "test.ws.ws.ws", "test.ws.ws.persistence.model", "test.ws.ws"})
@EnableJpaRepositories(basePackages = "test.ws.ws.persistence.repo.impl")
@EntityScan(basePackages = "test.ws.ws.persistence.model")

public class App
{
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	/*@Autowired
	private TemplateImpl templateRepo;
	
	@Autowired
	private IOrganizationRepository iOrgan;*/
	//private static Settings settings = Settings.get();

	public static void main(String args[]) throws SQLException {
		Server.createTcpServer("-tcpAllowOthers").start();
		SpringApplication.run(App.class, args);
		
	}

	
	 @Bean
	 public StoreServiceSoap storeServiceSoap() {
	        return new StoreServiceSoap();
	 }
	 
	@Bean
	public LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean factoryBean = new LocalEntityManagerFactoryBean();
		factoryBean.setPersistenceUnitName("asrclient-ff");
		return factoryBean;
	}
}
