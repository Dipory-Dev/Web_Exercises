package com.test01.anno;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyNickname {
//    private Nickname nickname;

    @Autowired
    private Nickname nname;

    public Nickname getNickname() {
        return nname;
    }

    public void setNickname(Nickname nickname) {
        this.nname = nickname;
    }

    @Override
    public String toString() {
        return "MyNickname{" +
                "nickname=" + nname +
                '}';
    }
}
