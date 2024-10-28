package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test01/applicationContext.xml");
        MyNickname mynickname = context.getBean("mynickname", MyNickname.class);
        System.out.println(mynickname);
    }
}
