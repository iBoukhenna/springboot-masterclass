package com.dzcode.springboot.masterclass.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.dzcode.springboot.masterclass.data.*.*(..))")
    public void dataLayerExecution() {}

    @Pointcut("execution(* com.dzcode.springboot.masterclass.business.*.*(..))")
    public void businessLayerExecution() {}
}
