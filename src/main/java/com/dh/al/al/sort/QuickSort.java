package com.dh.al.al.sort;

import org.junit.Test;

public class QuickSort {

    public void quickSort(int[] array, int p, int r) {
        if (p < r) {
            int q = partition(array, p, r);
            quickSort(array, p, q - 1);
            quickSort(array, q + 1, r);
        }
    }

    public int partition(int[] array, int p, int r) {
        int x = array[r];
        int k = p;
        for (; p < r; p++) {
            if (array[p] < x) {
                swap(array, k, p);
                k++;
            }
        }
        swap(array, k, r);
        return k;
    }

    public void swap(int[] a, int i, int j) {
        int swap = a[j];
        a[j] = a[i];
        a[i] = swap;
    }

    @Test
    public void testQuickSort() {
        int[] a = {24, 5, 89, 19, 11, 8, 2, 3, 9, 7, 16};
        quickSort(a, 0, a.length - 1);
        Print.print(a);
    }
}
