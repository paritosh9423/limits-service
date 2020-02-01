package com.paritosh.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.paritosh.microservices.limitsservice.beans.Configuration;
import com.paritosh.microservices.limitsservice.beans.LimitConfigurtion;

@RestController
public class LimitsConfigurationController {
	@Autowired
	private Configuration config;
	@GetMapping("/limits")
	public LimitConfigurtion retrieveLimitsFromConfiguration() {
		return new LimitConfigurtion(config.getMaximum(), config.getMinimum());
	}
	
	@GetMapping("/fault-tolerance-example")
	@HystrixCommand(fallbackMethod = "fallbackRetrieveConfiguration")
	public LimitConfigurtion retrieveConfiguration() {
		throw new RuntimeException("Not Available");
	}
	
	public LimitConfigurtion fallbackRetrieveConfiguration() {
		//return default config in case of any exceptions
		return new LimitConfigurtion(9,999);
	
	
	}
}
