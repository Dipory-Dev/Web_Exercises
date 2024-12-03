package com.test05.sort;

public class BubbleSort {
    public static void bubble(int a[], int n) {
        for (int i = 0; i < n-1; i++) {
            int cnt = 0;
            for (int j = n-1; j > i; j--) {
                if(a[j-1] > a[j]) {
                    int temp = a[j-1];
                    a[j-1] = a[j];
                    a[j] = temp;
                    cnt++;
                }
            }
            if (cnt == 0) {
                break;
            }
        }
    }
}
