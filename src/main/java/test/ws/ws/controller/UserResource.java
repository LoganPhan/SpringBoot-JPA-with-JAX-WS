package test.ws.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import test.ws.ws.persistence.model.Configuration;
import test.ws.ws.persistence.repo.ConfigurationRepository;

@RestController
public class UserResource {
	@Autowired
    ConfigurationRepository iConfigRepo;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    Collection<Configuration> hello() {
        return iConfigRepo.getAll();
    }
    
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    Configuration create(@RequestBody Configuration config) {
        return iConfigRepo.saveAndFlush(config);
    }
}
