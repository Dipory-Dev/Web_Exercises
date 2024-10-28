package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test02/applicationContext.xml");
        Person student = context.getBean("student", Person.class);
        Person teacher = context.getBean("teacher", Person.class);

        System.out.println("---------Student------------");
        student.classWork();
        System.out.println("---------Teacher------------");
        teacher.classWork();
    }
}
