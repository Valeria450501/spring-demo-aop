package com.luv2code.aopdemo.aspect;

import java.util.logging.Logger;

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
	
	private static Logger myLogger = Logger.getLogger(MyDemoLoggingAspect.class.getName());
	
	@Around("execution(* com.luv2code.aopdemo.service.*.getFortune(..))")
	public Object arounfGetFortuhne(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		String methodName = theProceedingJoinPoint.getSignature().toString();
		
		myLogger.info("\n=======> Ececuting @Around " + methodName);	
		
		long begin = System.currentTimeMillis();
		Object result = null;		
		try {
			result =theProceedingJoinPoint.proceed();
		} catch (Exception ex) {
			myLogger.warning("\\n=======> Ececuting @Around: " + ex.getMessage());
			result = "9 lives...you are still alive";
		}
		
		long end = System.currentTimeMillis();
		
		myLogger.info("\\n=======> Ececuting @Around: " + (end - begin) / 1000.0 + " seconds.");

		return result;
	}
	
	@After("execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))")
	public void afterFinallyFindAccountAdvice(JoinPoint theJoinPoint) {
		String methodName = theJoinPoint.getSignature().toString();
		
		myLogger.info("\n=======> @After  " + methodName);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccount(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		String methodName = theJoinPoint.getSignature().toString();
		
		myLogger.info("\n=======> Ececuting @AfterThrowing " + methodName);
		myLogger.info("\n=======> theExc is: " + theExc);
	}

	@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNotGetterSetter()")
	public void beforeAddAccount(JoinPoint theJoinPoint) {
		myLogger.info("\n=======>>>>> Executiong @Before addAccount()");
		
		MethodSignature signature = (MethodSignature) theJoinPoint.getSignature();
		
		myLogger.info("MethodSignature: " + signature);
		
		Object[] args = theJoinPoint.getArgs();
		
		for (Object tempArg : args) {
			myLogger.info(tempArg.toString());
			
			if(tempArg instanceof Account) {
				Account theAccount = (Account) tempArg;
				myLogger.info("Account name: " + theAccount.getName());
			}
		}
	}
}
