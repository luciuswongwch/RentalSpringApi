package com.luciuswong.renting.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class LoggerAspect {
    @AfterThrowing(value = "execution(* com.luciuswong.renting.*.*(..))", throwing="ex")
    public void logException(JoinPoint joinPoint, Exception ex) {
        log.error(joinPoint.getSignature() + " - Exception was thrown due to: " + ex.getMessage());
    }
}
