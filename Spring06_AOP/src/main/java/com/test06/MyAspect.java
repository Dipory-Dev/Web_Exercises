package com.test06;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {

    @Pointcut("execution(public * * (..))")
    public void myClass() {}

    @Before("myClass()")
    public void before() {
        System.out.println("Turn on the computer");
    }

    @After("myClass()")
    public void after() {
        System.out.println("Turn off the computer");
    }

}
