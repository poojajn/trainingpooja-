package com.trainig.exilant.microservice;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("currency-service")
public class Configuration {
	private int inr;
	private int usd;
	public int getInr() {
		return inr;
	}
	public void setInr(int inr) {
		this.inr = inr;
	}
	public Configuration(int inr, int usd) {
		super();
		this.inr = inr;
		this.usd = usd;
	}
	public int getUsd() {
		return usd;
	}
	public void setUsd(int usd) {
		this.usd = usd;
	}
	public  Configuration() {}
	
	

}
