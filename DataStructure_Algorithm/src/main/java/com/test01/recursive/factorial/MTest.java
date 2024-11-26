package com.test01.recursive.factorial;

import java.util.Scanner;

public class MTest {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("Number : ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Factorial of " + n + " : " + f.factorial(n));
    }
}
