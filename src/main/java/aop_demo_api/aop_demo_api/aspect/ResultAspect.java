package aop_demo_api.aop_demo_api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
//after service successfully return a value
//@afterreturnig doesnt run if we get an exception, means the method not successfully ran.
public class ResultAspect {


    //point cut let us restrict the access
    @AfterReturning(
            pointcut = "execution(* aop_demo_api.aop_demo_api.service.*.*(..))",
            returning = "result" )
    public void AfterThrowingAspect(JoinPoint joinPoint,Object result){
        log.info("method {} returned {}",
                joinPoint.getSignature().getName(), result);    }




}
