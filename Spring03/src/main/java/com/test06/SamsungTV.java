package com.test06;

public class SamsungTV implements TV{


    public SamsungTV() {
        System.out.println("SamsungTV");
    }

    @Override
    public void powerOn() {
        System.out.println("Samsung TV is powered on");
    }

    @Override
    public void powerOff() {
        System.out.println("Samsung TV is powered off");
    }

    @Override
    public void volUp() {
        System.out.println("Samsung TV is voluming up");
    }

    @Override
    public void volDown() {
        System.out.println("Samsung TV is voluming down");
    }
}
