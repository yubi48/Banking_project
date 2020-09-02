package com.rab3tech.aop.advice;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class DataLoggerAdvice {
	
private static final Logger logger = LoggerFactory.getLogger(DataLoggerAdvice.class);
	
	//What kind of method calls I would intercept
	//execution(* PACKAGE.*.*(..))
	//Weaving & Weaver
    //.* - all the classes
    //.* = all the method
     //.. method with any parameter
    //* -any access specifier 
/*
 * @Before("execution(* com.rab3tech.customer.service.impl.*.*(..))") public
 * void logMessage(JoinPoint joinPoint) { String
 * name=joinPoint.getSignature().getName();
 * logger.info("_________________________________________________");
 * logger.info(" Method name = "+name+" is called at "+new Date()); //Object[]
 * args -List logger.info(" Method inputs are  {}",
 * Arrays.asList(joinPoint.getArgs()));
 * logger.info("_________________________________________________"); }
 */
	
	@Around("execution(* com.rab3tech.customer.service.impl.*.*(..))")
	public Object computeTime(ProceedingJoinPoint joinPoint) {
		String name=joinPoint.getSignature().getName();
		long startTime = System.currentTimeMillis();
		logger.info(" Method name = "+name+" is called at startTime  = "+startTime+" Millies");
		logger.info(" Method inputs are  {}", Arrays.asList(joinPoint.getArgs()));
		Object object=null;
		try {
			 //go ahead and call actual methods
			object=joinPoint.proceed();
		} catch (Throwable e) {
			//e.printStackTrace();
			logger.error(e.getStackTrace().toString());
		}
		long endTime=System.currentTimeMillis();
		logger.info(" Method name = "+name+" is called at endTime  =  "+endTime+" Millies");
		long timeTaken =endTime- startTime;
		logger.info("Time Taken by {} is {}", name, timeTaken);
		return object;
	}

/*@Around("@annotation(com.rab3tech.aop.advice.TimeLogger)")
public Object computeTime(ProceedingJoinPoint joinPoint) {
	String name=joinPoint.getSignature().getName();
	long startTime = System.currentTimeMillis();
	logger.info(" Method name = "+name+" is called at startTime  = "+startTime+" Millies");
	logger.info(" Method inputs are  {}", Arrays.asList(joinPoint.getArgs()));
	Object object=null;
	try {
		object=joinPoint.proceed();
	} catch (Throwable e) {
		e.printStackTrace();
	}
	long endTime=System.currentTimeMillis();
	logger.info(" Method name = "+name+" is called at endTime  =  "+endTime+" Millies");
	long timeTaken =endTime- startTime;
	logger.info("Time Taken by {} is {}", name, timeTaken);
	return object;
}
*/


}
