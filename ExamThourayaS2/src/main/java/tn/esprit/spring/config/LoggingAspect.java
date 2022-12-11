package tn.esprit.spring.config;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import static tn.esprit.spring.config.PerformanceAspect.logger;

@Component
@Aspect
public class LoggingAspect {
private static final Logger log = LogManager.getLogger(LoggingAspect.class);
@Before("execution(* tn.esprit.spring.service.*.set*(..))")
public void logMethodEntry(JoinPoint joinPoint) {
String name = joinPoint.getSignature().getName();
log.info("In method " + name + " : ");
}
@After("execution(* tn.esprit.spring.service.*.set*(..))")
public void logMethodExit(JoinPoint joinPoint) {
	String name = joinPoint.getSignature().getName();
	logger.info("Out of " + name );
}}