package src;

import java.util.Arrays;

public class MergeSort extends Sort {

    private static Comparable[] arr;

    private static void merge (Comparable[] a, int lo, int mid, int hi) {
        int i = lo;
        /**
         * j 必须从 mid + 1 算起，不能从 mid 算起
         * 要考虑 lo = mid = hi - 1 的场景
         */
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            arr[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = arr[j++];
            else if (j > hi) a[k] = arr[i++];
            else if (less(arr[i], arr[j])) a[k] = arr[i++];
            else a[k] = arr[j++];
        }
    }

    /**
     * bottom to top
     * 自底向上
     */
    private static void sort (Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = (lo + hi) / 2;

        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    public static void sort (Comparable[] a) {
        arr = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    public static void main (String[] args) {
        Comparable[] a = generateTrial(50);

        MergeSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
