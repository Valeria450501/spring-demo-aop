package com.luv2code.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
	
		List<Account> theAccounts = accountDAO.findAccount();
		
		System.out.println("AfterReturningDemoApp\n---\n");
		System.out.println(theAccounts);
		System.out.println("---");
				
		context.close();
	}

}
