package com.example.httpLoggerStarter.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
@Slf4j
public class ControllerLogAspect {

    @Around("execution(public * *..*Controller.*(..))")
    public Object logControllerMethodExecution(ProceedingJoinPoint proceedingJoinPoint) {
        log.info(
                String.format("Method %s start execution with args %s",
                        proceedingJoinPoint.getSignature().getName(), Arrays.toString(proceedingJoinPoint.getArgs()))
        );

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            log.warn(String.format("Method %s produced exception %s",
                    proceedingJoinPoint.getSignature(), e)
            );
            throw new RuntimeException(e);
        }
        log.info(String.format("Method %s finished execution and returned: %s",
                proceedingJoinPoint.getSignature().getName(), result)
        );
        return result;
    }

    @Around("execution(public * *..*Controller.*(..))")
    public Object logControllerMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) {
        long millis = System.currentTimeMillis();

        Object result = null;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

        log.info(String.format("Method %s finished execution in %s milliseconds",
                proceedingJoinPoint.getSignature().getName(), System.currentTimeMillis() - millis)
        );
        return result;
    }
}
