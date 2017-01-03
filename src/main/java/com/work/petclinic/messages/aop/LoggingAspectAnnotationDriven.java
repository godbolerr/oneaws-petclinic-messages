package com.work.petclinic.messages.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@EnableAspectJAutoProxy
@Component
@Configuration
public class LoggingAspectAnnotationDriven {
	
    protected final Logger log = LoggerFactory.getLogger(this.getClass());

	@Before("execution(* com.work.petclinic.messages.service.MessageServiceImpl.*(..))")
	public void beforMessageServiceImple(JoinPoint jp) {
		log.info("(BeforeMessageServiceImpl) '" + jp.getSignature().toLongString() + "'");
	}

	@After("execution(* com.work.petclinic.messages.service.MessageServiceImpl.*(..))")
	public void afterMessageServiceImpl(JoinPoint jp) {
		log.info("(AfterMessageServiceImpl) '" + jp.getSignature().toLongString() + "'");
	}
	
    @Before("execution(public * com.work.petclinic.messages.api.rest.*Controller.*(..))")
    public void logBeforeRestCall(JoinPoint pjp) throws Throwable {
    	log.info(":::::AOP Before REST call:::::" + pjp);
    }	

}
