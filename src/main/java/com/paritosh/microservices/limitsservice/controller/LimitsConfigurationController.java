package com.paritosh.microservices.limitsservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paritosh.microservices.limitsservice.beans.LimitConfigurtion;

@RestController
public class LimitsConfigurationController {
	@GetMapping("/limits")
	public LimitConfigurtion retrieveLimitsFromConfiguration() {
		return new LimitConfigurtion(1000, 1);
	}
}
