package com.test06;

import com.test05.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test06/applicationContext.xml");
        Person s = context.getBean("student", Person.class);
        System.out.println("=======student========");
        s.classWork();
        Person t = context.getBean("teacher", Person.class);
        System.out.println("=======teacher========");
        t.classWork();
    }
}
