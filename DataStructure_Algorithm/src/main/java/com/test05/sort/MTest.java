package com.test05.sort;

public class MTest {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 8, 2, 9};
        BubbleSort b = new BubbleSort();

        b.bubble(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
