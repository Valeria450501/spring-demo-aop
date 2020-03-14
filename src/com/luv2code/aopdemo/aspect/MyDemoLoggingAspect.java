package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	public void beforeAddAccount() {
		System.out.println("\n=======>>>>> Executiong @Before addAccount()");
	}
}
