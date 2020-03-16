package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNotGetterSetter() {}
	
	@Before("forDaoPackageNotGetterSetter()")
	public void beforeAddAccount() {
		System.out.println("\n=======>>>>> Executiong @Before addAccount()");
	}
	
	@Before("forDaoPackageNotGetterSetter()")
	public void performAnalytics() {
		System.out.println("\n=======>>>>> Perform Analytics @Before");
	}
}
