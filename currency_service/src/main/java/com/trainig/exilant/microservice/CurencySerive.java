package com.trainig.exilant.microservice;

import com.trainig.exilant.microservice.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurencySerive {

	@Autowired
	private Configuration currency;
	
	@GetMapping("/currency")
	public Configuration getconfiguration() {
		return new Configuration(1, 60);
	}
}
