package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");

        TV tv = context.getBean("lgtv", TV.class);
        tv.powerOn();
        TV tv2 = context.getBean("samsungtv", TV.class);
        tv2.powerOff();
    }
}
