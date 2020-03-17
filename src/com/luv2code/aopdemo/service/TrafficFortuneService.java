package com.luv2code.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {

	public String getFortune() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Too late to call a taxi....";
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("....RIP....");
		}
		return getFortune();
	}
}
