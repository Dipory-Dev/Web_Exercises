package com.test03;

public class MyAspect {
    public void before() {
        System.out.println("Turn on the computer");
    }

    public void after() {
        System.out.println("Turn off the computer");
    }
}
