package com.batis.security;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoginAscpect {
    //com.batis.controller

    @Pointcut("execution(* com.batis.controller.LoginController..*.*(..))")
    public void userLoginAscpect() {
    }

    // 前置通知
    @Before("userLoginAscpect()")
    public void doBeforeAdvice(JoinPoint joinPoint) {
        joinPoint.getKind();
    }

    // TODO 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
    // TODO 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
    // TODO returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，
    // TODO 对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
    // 后置返回通知
    @AfterReturning(value = "execution(* com.batis.controller.LoginController..*.*(..))", returning = "keys")
    public void doAfterReturningAdvice(JoinPoint joinPoint, Object keys) {

    }

    // 后置返回通知
    @AfterReturning(value = "execution(* com.batis.controller.LoginController..*.*(..))", returning = "keys", argNames = "keys")
    public void doAfterReturningAdvice2(String keys) {

    }

    @After("userLoginAscpect()")
    public void doAfterAdvice(JoinPoint joinPoint) {

    }

    // TODO 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
    // TODO 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
    // 环绕通知
    @Around("execution(* com.batis.controller.LoginController..*.*(..))")
    public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
//        proceedingJoinPoint.getSignature().getName()
        //obj之前可以写目标方法执行前的逻辑
        Object obj = null;
        try {
            //调用执行目标方法
            obj = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return obj;
    }

}
