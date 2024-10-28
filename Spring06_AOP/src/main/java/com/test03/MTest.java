package com.test03;

import com.test02.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test03/applicationContext.xml");

        Person student = context.getBean("student", Person.class);
        Person teacher = context.getBean("teacher", Person.class);

        System.out.println("---------Student------------");
        student.classWork();
        System.out.println("---------Teacher------------");
        teacher.classWork();
    }
}
