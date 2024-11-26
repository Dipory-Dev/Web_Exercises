package com.test01.recursive.factorial;

public class Factorial {
    public int factorial(int n) {
        int answer = 0;
        if (n > 0) {
            answer = n * factorial(n-1);
        } else {
            answer = 1;
        }
        return answer;
    }
}
