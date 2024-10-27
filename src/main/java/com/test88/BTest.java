package com.test88;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BTest {
    public static void main(String[] args) {
        ApplicationContext mb = new ClassPathXmlApplicationContext("com/test88/applicationContext.xml");

        Member kk = (Member) mb.getBean("kk");

        System.out.println(kk);

        MemberinfoBeanImpl minfo = (MemberinfoBeanImpl) mb.getBean("kkinfo");
        minfo.info();
    }
}
