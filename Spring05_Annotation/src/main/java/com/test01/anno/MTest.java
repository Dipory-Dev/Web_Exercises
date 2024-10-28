package com.test01.anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("com/test01/anno/applicationContext.xml");

        MyNickname myNickname = context.getBean("myNickname", MyNickname.class);
//        myNickname.setNickname(context.getBean("nickname", Nickname.class));
        System.out.println(myNickname);
    }
}
