package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/bean.xml");
        MessageBean bean = (MessageBean) factory.getBean("kor");
        bean.sayHello("스프링");

        bean = (MessageBean) factory.getBean("eng");
        bean.sayHello("Spring");
    }
}
