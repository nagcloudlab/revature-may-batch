package com.example.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    private static final Logger logger = Logger.getLogger("mts");

    @Before("execution(* transfer(..))")
    public void doRoleCheck(JoinPoint point) {
        String name = point.getSignature().getName();
        logger.info("role check before " + name);
    }

}
