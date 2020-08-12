package com.cowork.dutystem.configuration.aspect;

import com.cowork.dutystem.http.response.SuccessResponse;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class RestControllerAspect {

    /**
     * Controller 클래스 프록시
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("execution(* com.cowork.dutystem.controller.*.*(..))")
    public SuccessResponse<Object> restResponseHandler(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        return new SuccessResponse<>(HttpStatus.OK.value(), "성공하였습니다.", proceedingJoinPoint.proceed());
    }

}
