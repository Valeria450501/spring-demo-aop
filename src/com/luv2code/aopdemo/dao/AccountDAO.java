package com.luv2code.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Component
public class AccountDAO {

	private String name;
	private String serviceCode;
	
	public void addAccount(Account theAccount) {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void addAccount() {
		System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");
	}
	
	public void doWork() {
		System.out.println(getClass() + ": DOING MY WORK WORK......");
	}

	public String getName() {
		System.out.println(getClass() + " in getName()");
		return name;
	}

	public void setName(String name) {
		System.out.println(getClass() + " in setName()");
		this.name = name;
	}

	public String getServiceCode() {
		System.out.println(getClass() + " in getServiceCode()");
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		System.out.println(getClass() + " in setServiceCode()");
		this.serviceCode = serviceCode;
	}
	
	public List<Account> findAccount(boolean tripWire) {
		
		if(tripWire) {
			throw new RuntimeException("RIP");
		}
		
		List<Account> myAccounts = new ArrayList<Account>();
		myAccounts.add(new Account("User1", "qwerty"));
		myAccounts.add(new Account("User2", "12345"));
		myAccounts.add(new Account("User3", "password"));
		return myAccounts;
	}
}
