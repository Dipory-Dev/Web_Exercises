package com.test06;

public class LgTV implements TV{
    public LgTV() {
        System.out.println("Lg TV");
    }
    @Override
    public void powerOn() {
        System.out.println("Lg TV power on");
    }

    @Override
    public void powerOff() {
        System.out.println("Lg TV power off");
    }

    @Override
    public void volUp() {
        System.out.println("Lg TV vol up");
    }

    @Override
    public void volDown() {
        System.out.println("Lg TV vol down");
    }
}
