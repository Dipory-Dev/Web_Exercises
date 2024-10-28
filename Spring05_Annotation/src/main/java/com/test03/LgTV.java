package com.test03;

public class LgTV implements TV{

    @Override
    public void powerOn() {
        System.out.println("LgTV power on");
    }

    @Override
    public void powerOff() {
        System.out.println("LgTV power off");
    }

    @Override
    public void volUp() {
        System.out.println("LgTV vol up");
    }

    @Override
    public void volDown() {
        System.out.println("LgTV vol down");
    }
}
