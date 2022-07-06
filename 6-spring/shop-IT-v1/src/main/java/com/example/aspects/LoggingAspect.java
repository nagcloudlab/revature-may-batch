package com.example.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static Logger LOG = Logger.getLogger("shop");

    @Before("execution(* com.example.billing.*.*(..))")
    public void beforeLog(JoinPoint joinPoint){
        LOG.info("invoking "+joinPoint.toLongString());
    }

}
