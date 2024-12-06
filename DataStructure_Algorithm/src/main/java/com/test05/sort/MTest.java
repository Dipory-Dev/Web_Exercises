package com.test05.sort;

public class MTest {
    public static void main(String[] args) {
        int[] arr = {6, 4, 3, 7, 1, 8, 2, 9};
        BubbleSort b = new BubbleSort();

        b.bubble(arr, arr.length);
        System.out.println("Bubble sort");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println("----------------");
        System.out.println("Selection sort");
        int[] arr2 = {6, 4, 3, 7, 1, 8, 2, 9};
        SelectionSort s= new SelectionSort();
        s.selectionSort(arr2, arr2.length);

        for (int i : arr2) {
            System.out.print(i + " ");
        }

        System.out.println("----------------");
        System.out.println("Insertion sort");
        int[] arr3 = {6, 4, 3, 7, 1, 8, 2, 9};
        InsertionSort i = new InsertionSort();
        i.insertionSort(arr3, arr3.length);
        for (int j : arr3) {
            System.out.print(j + " ");
        }

        System.out.println("----------------");
        System.out.println("Quick sort");
        int[] arr4 = {6, 4, 3, 7, 1, 8, 2, 9};
        QuickSort q = new QuickSort();
        q.quickSort(arr4, 0, arr4.length - 1);
        for (int j : arr4) {
            System.out.print(j + " ");
        }
    }
}
