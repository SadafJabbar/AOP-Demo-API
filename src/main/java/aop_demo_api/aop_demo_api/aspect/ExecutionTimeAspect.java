package aop_demo_api.aop_demo_api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
//our method must return the service result back to caller method
public class ExecutionTimeAspect {


    @Around("@annotation(aop_demo_api.aop_demo_api.annotation.TrackExecution)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        log.info("Method {} executed in {} ms", joinPoint.getSignature().getName(), executionTime);
        return result;
    }
}