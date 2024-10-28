package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Before;


public class MyAspect {
    @Before("execution(public * * (..))")
    public void before(JoinPoint joinPoint) {
        System.out.println(joinPoint.getTarget());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println("Connect the internet");
    }
    @After("execution(public * * (..))")
    public void after(JoinPoint joinPoint) {
        System.out.println("Turn off the computer");
    }

    @AfterReturning(pointcut = "execution(public * * (..))", returning="returnVal")
    public void returning(Object returnVal) {
        System.out.println(returnVal + "Not holiday");
    }

    public void throwing() {
        System.out.println("Holiday");
    }

}
