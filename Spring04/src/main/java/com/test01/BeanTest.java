package com.test01;

import java.util.*;

public class BeanTest {
    public BeanTest() {
        System.out.println("Basic Constructor(no - args)");
    }

    public BeanTest(Date date) {
        System.out.println("Date constructor (Date : " + date + ")");
    }

    public void setMyClass(MyClass myClass) {
        System.out.println("Call setMyClass() : " + myClass);
    }

    public void setMyDate(Date date) {
        System.out.println("Call setMyDate() : " + date);
    }

    public void setMynumber(int number) {
        System.out.println("Call setNumber() : " + number);
    }

    public void setArrrry (String[] arr) {
        System.out.println("Call String[]");
        for (String s : arr) {
            System.out.println(s);
        }
    }

    public void setList (List<String> list) {
        System.out.println("Call setList()");
        for (String s : list) {
            System.out.println(s);
        }
    }

    public void setMap (Map<String, String> map) {
        System.out.println("Call setMap()");
        Collection<String> values = map.values();
        for (String s : values) {
            System.out.println(s);
        }
    }

    public void setScore(List<Score> list) {
        System.out.println("Call setScore()");
        for(Score s : list) {
            System.out.println(s);
        }
    }
    public void setScore2(List<Score> list) {
        System.out.println("Call setScore()");
        for(Score s : list) {
            System.out.println(s);
        }
    }
}
