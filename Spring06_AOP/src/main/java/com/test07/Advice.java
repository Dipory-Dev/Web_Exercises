package com.test07;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class Advice implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        String methodName = invocation.getMethod().getName();
        StopWatch timer = new StopWatch();

        timer.start();
        System.out.println("[LOG] Method " + methodName + " is Calling");
        Object obj = invocation.proceed();
        timer.stop();
        System.out.println("[LOG] Method " + methodName + " is Done");
        System.out.println("[LOG] " + timer.getTotalTimeSeconds() + " sec");
        return obj;
    }
}
