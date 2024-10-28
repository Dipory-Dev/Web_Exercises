package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
        School person = context.getBean("myschool", School.class);
        System.out.println(person);
    }
}
