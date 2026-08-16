package aop_demo_api.aop_demo_api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class ExceptionAspect {

    @AfterThrowing(
            pointcut = "execution(* aop_demo_api.aop_demo_api.service.*.*(..))",
            throwing = "exception"
    )
    public void afterThrowing(JoinPoint joinPoint, Throwable exception) {

        log.error(
                "Exception in method {}: {}",
                joinPoint.getSignature().getName(),
                exception.getMessage()
        );
    }
}