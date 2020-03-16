package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNotGetterSetter()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		System.out.println("\n=======>>>>> Executiong @Before addAccount()");
		
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("MethodSignature: " + signature);
	}
}
