package com.test03;

public class SamsungTV implements TV{

    @Override
    public void powerOn() {
        System.out.println("samsung TV is powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("samsung TV is powered off");
    }

    @Override
    public void volUp() {
        System.out.println("samsung TV is vol up");
    }

    @Override
    public void volDown() {
        System.out.println("samsung TV is vol down");
    }
}
