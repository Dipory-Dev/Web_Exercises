package com.test05.sort;

public class QuickSort {
    public static void quickSort(int[] a, int left, int right) {
        int lc = left;
        int rc = right;
        int p = a[(lc + rc) / 2];

        do {
            while(a[lc] < p) {lc++;}
            while(a[rc] > p) {rc--;}
            if(lc <= rc) {
                int temp = a[lc];
                a[lc] = a[rc];
                a[rc] = temp;
                lc++;
                rc--;
            }
        } while (lc <= rc);

        if(left < rc) {
            quickSort(a, left, rc);
        }
        if(right > lc) {
            quickSort(a, lc, right);
        }
    }
}
