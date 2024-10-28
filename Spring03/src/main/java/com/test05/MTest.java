package com.test05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test05/applicationContext.xml");

        Developer kim = (Developer) context.getBean("kimjs");
        System.out.println(kim);

        Engineer kang = (Engineer) context.getBean("kangdw");
        System.out.println(kang);
    }
}
