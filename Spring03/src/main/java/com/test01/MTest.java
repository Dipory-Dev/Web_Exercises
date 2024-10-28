package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");

        AbstractTest test = (AbstractTest) context.getBean("test");
        System.out.println(test.dayInfo());
    }
}
