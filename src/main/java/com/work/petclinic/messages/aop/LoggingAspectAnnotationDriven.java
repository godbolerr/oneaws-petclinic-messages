/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.work.petclinic.messages.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * Class used to house all aspect-related method.
 *
 * @author arnaldopiccinelli
 */
@Aspect
@EnableAspectJAutoProxy
@Component
@Configuration
@Slf4j
public class LoggingAspectAnnotationDriven {

	@Before("execution(* com.work.petclinic.messages.service.MessageServiceImpl.*(..))")
	public void beforMessageServiceImple(JoinPoint jp) {
		log.info("(BeforeMessageServiceImpl) '" + jp.getSignature().toLongString() + "'");
	}

	@After("execution(* com.work.petclinic.messages.service.MessageServiceImpl.*(..))")
	public void afterMessageServiceImpl(JoinPoint jp) {
		log.info("(AfterMessageServiceImpl) '" + jp.getSignature().toLongString() + "'");
	}

}
