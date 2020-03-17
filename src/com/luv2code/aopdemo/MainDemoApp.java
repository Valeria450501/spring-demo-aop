package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		List<Account> theAccounts = null;
		
		try {
			boolean tripWire = true;
			theAccounts = accountDAO.findAccount(tripWire);
		} catch (Exception e) {
			System.out.println("Main program ---> exception: " + e.getMessage());
		}
		
		System.out.println("AfterThrowingDemoApp\n---\n");
		System.out.println(theAccounts);
		System.out.println("---");
				
		context.close();
	}

}
