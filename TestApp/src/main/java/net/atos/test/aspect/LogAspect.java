package net.atos.test.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Component
public class LogAspect {
	
	//Logger logger=Logger.getLogger(LogAspect.class.getName());
	
	@Pointcut("execution(* net.atos.test.rest.*.*(..))")
	public void logPointCut() {
		
	}
	
	@Around("logPointCut()")
	public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		Long t1=System.currentTimeMillis();
		log.info("From logging Aspects before "+proceedingJoinPoint.getSignature());
		Object resultObject = proceedingJoinPoint.proceed();
		log.info("From logging Aspects after "+proceedingJoinPoint.getSignature());
		Long t2=System.currentTimeMillis();
		log.info("Duration: "+(t2-t1));
		return resultObject;
	}

}
