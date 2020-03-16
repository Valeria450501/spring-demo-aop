package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		accountDAO.addAccount(new Account());
		theMembershipDAO.addSillyMember();
		
		accountDAO.addAccount();
		accountDAO.doWork();
		
		accountDAO.setName("foobar");
		accountDAO.setServiceCode("15");
		
		accountDAO.getName();
		accountDAO.getServiceCode();
				
		context.close();
	}

}
