package com.test04;

public class Student implements Person{
    @Override
    public String classWork() {
        System.out.println("Check the QR");
        return "Spring";
    }
}
