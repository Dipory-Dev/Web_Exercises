package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");

        Person s = context.getBean("student", Person.class);
        Person t = context.getBean("teacher", Person.class);

        System.out.println("=====Student=======");
        s.classWork();
        System.out.println("=====Teacher=======");
        t.classWork();
    }
}
