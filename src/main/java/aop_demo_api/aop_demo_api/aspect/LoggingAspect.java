package aop_demo_api.aop_demo_api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
//before and after a method in service
public class LoggingAspect {


    @Before("execution(* aop_demo_api.aop_demo_api.service.*.*(..))")
    public void beforeAspect(JoinPoint joinPoint) {
        log.info("Method started: {}", joinPoint.getSignature().getName());
    }

    @After("execution(* aop_demo_api.aop_demo_api.service.*.*(..))")
    public void afterAspect(JoinPoint joinPoint) {
        log.info("Method finished: {}", joinPoint.getSignature().getName());
    }
}
