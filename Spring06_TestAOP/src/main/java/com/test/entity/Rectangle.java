package com.test.entity;

import com.test.main.Shape;

public class Rectangle extends Shape {

    public Rectangle() {}

    public Rectangle(String title, int width, int height) {
        super(title, width, height);
    }

    @Override
    public void viewSize() {
        System.out.println(getTitle() + "'s width is " + (getWidth() * getHeight()));
    }
}
