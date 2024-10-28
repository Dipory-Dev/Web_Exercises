package com.test01;

public class Student {
    public void classWork() {
        System.out.println("Turn on the computer");
        System.out.println("Connect the internet");

        try {
            System.out.println("Check the QR");
            System.out.println("Take a class");
        } catch (Exception e) {
            System.out.println("Today is holiday");
        } finally {
            System.out.println("Close the internet");
        }
    }
}
