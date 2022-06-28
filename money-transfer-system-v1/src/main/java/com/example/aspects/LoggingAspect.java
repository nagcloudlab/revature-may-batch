package com.example.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = Logger.getLogger("mts");
//
//    @Before("execution(* transfer(..))")
//    public void doLogBefore(JoinPoint point) {
//        String name = point.getSignature().getName();
//        logger.info("invoking " + name + " on " + point.getTarget());
//    }
//
//    @AfterReturning(pointcut = "execution(* transfer(..))", returning = "r")
//    public void doLogAfterReturning(JoinPoint point, Object r) {
//        String name = point.getSignature().getName();
//        logger.info("successfully invoked " + name + " on " + point.getTarget());
//    }
//
//    @AfterThrowing(pointcut = "execution(* transfer(..))", throwing = "e")
//    public void doLogAfterThrowing(JoinPoint point, Throwable e) {
//        String name = point.getSignature().getName();
//        logger.info("failed when invoked " + name + " on " + point.getTarget() + "-" + e.getMessage());
//    }
//
//    @After("execution(* transfer(..))")
//    public void doLogAfter(JoinPoint point) {
//        String name = point.getSignature().getName();
//        logger.info("after advice " + name + " on " + point.getTarget());
//    }

    @Around("execution(* transfer(..))")
    public void doLogAround(ProceedingJoinPoint point) {
        String name = point.getSignature().getName();
        try {
            logger.info("before " + name + " on " + point.getTarget());
            point.proceed();
            logger.info("after returning " + name + " on " + point.getTarget());
        } catch (Throwable e) {
            logger.info("after throwing " + name + " on " + point.getTarget());
        } finally {
            logger.info("after " + name + " on " + point.getTarget());
        }
    }


}
