package com.test.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test/applicationContext.xml");
        Shape t = context.getBean("tri", Shape.class);
        Shape r = context.getBean("rec", Shape.class);
        t.viewSize();
        System.out.println("==================");
        r.viewSize();
    }
}
