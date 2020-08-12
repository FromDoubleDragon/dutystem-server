package com.cowork.dutystem.configuration.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ServiceExceptionAspect {

    @Around("execution(* com.cowork.dutystem.service.*.*(..))")
    public Object serviceExceptionHandler(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch(Throwable e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
