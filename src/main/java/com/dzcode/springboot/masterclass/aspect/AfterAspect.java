package com.dzcode.springboot.masterclass.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAspect {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(value="com.dzcode.springboot.masterclass.aspect.CommonJoinPointConfig.dataLayerExecution()",
                    returning="result"
    )
    public void afterReturning(JoinPoint joinPoint, Object result) {
        logger.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value="com.dzcode.springboot.masterclass.aspect.CommonJoinPointConfig.dataLayerExecution()",
            throwing="exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Exception exception) {
        logger.info("{} throw exception {}", joinPoint, exception);
    }

    @After(value="com.dzcode.springboot.masterclass.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void after(JoinPoint joinPoint) {
        logger.info("after execution of {}", joinPoint);
    }

}
