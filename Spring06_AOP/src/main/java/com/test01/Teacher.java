package com.test01;

public class Teacher {
    public void classWork() {
        System.out.println("Turn on the computer");
        System.out.println("Connect the internet");

        try {
            System.out.println("Share the QR");
        } catch (Exception e) {
            System.out.println("Today is holiday");
        } finally {
            System.out.println("Turn off the computer");
        }
    }
}
