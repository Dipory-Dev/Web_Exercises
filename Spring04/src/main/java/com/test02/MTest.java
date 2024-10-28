package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");

        MyFood food = (MyFood) context.getBean("myfood");
        System.out.println(food);

//        Food fd = (Food) context.getBean("ramyeon");
//        System.out.println(fd);

    }
}
