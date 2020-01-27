package com.paritosh.microservices.limitsservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
