package com.test01;

public class MessageBeanImpl implements MessageBean{

    private String fruit;
    private int cost;

    public MessageBeanImpl() {
        this.fruit = "banana";
        this.cost = 5000;
    }

    public MessageBeanImpl(int cost, String fruit) {
        this.cost = cost;
        this.fruit = fruit;
    }

    @Override
    public void sayHello() {
        System.out.println("Fruit : " + fruit + "\t Cost : " + cost);
    }
}
