package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test04/applicationContext.xml");

        Developer kim = context.getBean("kim", Developer.class);
        System.out.println(kim);

        Engineer kang = context.getBean("kang", Engineer.class);
        System.out.println(kang);
    }
}
