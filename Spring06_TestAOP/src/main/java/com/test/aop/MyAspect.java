package com.test.aop;

public class MyAspect {

    public void before() {
        System.out.println("Calc the width");
    }

    public void after() {
        System.out.println("Print the height");
    }
}
