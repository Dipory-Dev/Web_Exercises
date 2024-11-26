package com.test01.recursive.hanoi;

public class Hanoi {
    public static void main(String[] args) {

    }

    public void hanoi(int no, int x, int y){
        if (no > 1) {
            hanoi(no - 1, x, 6-x-y);
        }
        System.out.println("원판 " + no + "를 " + x + "번 기둥에서 " + y + "번 기둥으로 옮김");
        if (no > 1) {
            hanoi(no - 1, 6-x-y, x);
        }
    }
}
