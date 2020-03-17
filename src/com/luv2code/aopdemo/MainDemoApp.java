package com.luv2code.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;
import com.luv2code.aopdemo.service.TrafficFortuneService;

public class MainDemoApp {

	private static Logger myLogger = Logger.getLogger(MainDemoApp.class.getName());
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

		myLogger.info("AroundWithLoggerHandleExceptionDemoApp\n---\n");
		boolean tripWire = true;
		myLogger.info("getFortune:" + fortuneService.getFortune(tripWire));
		myLogger.info("Finished.");
		context.close();
	}

}
