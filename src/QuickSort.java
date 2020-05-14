package src;

import java.util.Arrays;

public class QuickSort extends Sort {
    private static int f (Comparable[] a, int lo, int hi) {
        int mid = lo;
        int i = lo + 1;
        int j = hi;
        while (i < j) {
            if (less(a[i], a[mid])) {
                exchange(a, i, mid);
                mid = i;
            }
            i++;
            if (less(a[j], a[mid])) {
                exchange(a, j, mid);
                mid = j;
            }
            j--;
        }
        return mid;
    }

    public static void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = f(a, lo, hi);
        sort(a, lo, mid - 1);
        sort(a, mid + 1, hi);
    }

    public static void main (String[] args) {
        Comparable[] a = generateTrial(50);

        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
