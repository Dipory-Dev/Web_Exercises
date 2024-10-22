package com.test88;

public class MemberinfoBeanImpl implements MemberinfoBean{

    private int age;
    private String name;

    public MemberinfoBeanImpl() {}

    public MemberinfoBeanImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public void info() {
        System.out.println("Name : " + name + " Age : " + age);
    }
}
