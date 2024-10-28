package com.test07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test07/applicationContext.xml");

        MessageBean bean = context.getBean("targetBean", MessageBean.class);
        bean.sayHello();
    }
}
