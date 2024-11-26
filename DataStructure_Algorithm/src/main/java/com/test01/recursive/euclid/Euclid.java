package com.test01.recursive.euclid;

public class Euclid {
    public static void main(String[] args) {
        Euclid e = new Euclid();
        int gcd = e.euclid(8, 22);
        System.out.println(gcd);
    }


    public int euclid (int n1, int n2) {
        if (n2 == 0) {
            return n1;
        } else {
            return euclid(n2, n1 % n2);
        }
    }
}
