package com.dzcode.springboot.masterclass.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AroundAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("com.dzcode.springboot.masterclass.aspect.CommonJoinPointConfig.trackTimeAnnotation()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", proceedingJoinPoint, timeTaken);
        return result;
    }
}
