package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object arounfGetFortuhne(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String methodName = theProceedingJoinPoint.getSignature().toString();
		
		System.out.println("\n=======> Ececuting @Around " + methodName);	
		
		long begin = System.currentTimeMillis();
		
		Object result = theProceedingJoinPoint.proceed();
		
		long end = System.currentTimeMillis();
		
		System.out.println("\\n=======> Ececuting @Around: " + (end - begin) / 1000.0 + " seconds.");
		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String methodName = theJoinPoint.getSignature().toString();
		
		System.out.println("\n=======> @After  " + methodName);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String methodName = theJoinPoint.getSignature().toString();
		
		System.out.println("\n=======> Ececuting @AfterThrowing " + methodName);
		System.out.println("\n=======> theExc is: " + theExc);
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNotGetterSetter()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		System.out.println("\n=======>>>>> Executiong @Before addAccount()");
		
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("MethodSignature: " + signature);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			System.out.println(tempArg);
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				System.out.println("Account name: " + theAccount.getName());
			}
		}
	}
}
