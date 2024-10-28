package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");

        Emp kim = context.getBean("kim", Emp.class);
        System.out.println(kim);

        Emp kang = (Emp) context.getBean("kang");
        System.out.println(kang);
    }
}
