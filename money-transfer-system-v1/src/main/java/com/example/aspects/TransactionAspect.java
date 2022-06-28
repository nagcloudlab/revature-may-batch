package com.example.aspects;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    private static final Logger logger = Logger.getLogger("mts");


    @Around("execution(* transfer(..))")
    public void doTxnAround(ProceedingJoinPoint point) {
        String name = point.getSignature().getName();
        try {
            logger.info("begin transaction");
            point.proceed();
            logger.info("commit transaction");
        } catch (Throwable e) {
            logger.info("rollback transaction");
        } finally {
            logger.info("close connection");
        }
    }

}
