package com.test01;

public class MyNickname {
    private Nickname nickname;

    public Nickname getNickname() {
        return nickname;
    }

    public void setNickname(Nickname nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "MyNickname{" +
                "nickname=" + nickname +
                '}';
    }
}
