package src;

import java.util.*;

class Sort {
    protected static boolean less (Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected static void exchange (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    protected static Comparable[] generateTrial (int n) {
        Random r = new Random();
        Comparable[] a = new Comparable[n];
        for (int i = 0; i < n; i++) {
            a[i] = r.nextInt(n);
        }
        return a;
    }
}

class SelectionSort extends Sort {
    public static Comparable[] sort (Comparable[] a) {
       int n = a.length;
       for (int i = 0; i < n; i++) {
           int min = i;
           for (int j = i + 1; j < n; j++) {
               if (less(a[j], a[min])) min = j;
           }
           exchange(a, i, min);
       }

       return a;
    }

    public static void main (String[] args) {
        Comparable[] a = generateTrial(50);
        Comparable[] sorted = SelectionSort.sort(a);
        System.out.println(Arrays.toString(sorted));
    }
}

class InsertionSort extends Sort {
    public static Comparable[] sort (Comparable[] a) {
        int N = a.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
        return a;
    }

    public static void main (String[] args) {
        Comparable[] a = generateTrial(50);
        Comparable[] sorted = SelectionSort.sort(a);
        System.out.println(Arrays.toString(sorted));
    }
}

/**
 * 插入排序的问题是当距离较远的两个数调换所需的操作次数太多
 * 希尔排序的改进点是：先保证较远的两个数直接调换，最终仍然会执行一次插入排序
 * 但最后一次执行时，因为数据经过"预处理"变得相对有序，尤其是距离较远的两个数大概率都已经排好序了
 * 因此总的来看，希尔排序能提高插入排序的效率
 */
class ShellSort extends Sort {
    public static Comparable[] sort (Comparable[] a) {
        int h = 1;
        int n = a.length;
        while (h * 3 < n) {
            h *= 3;
        }

        while (h >= 1) {
            for (int i = h; i < n; i += h) {
                for (int j = i; j >= 0 && less(a[j], a[j - h]); j -= h) {
                    exchange(a, j, j - h);
                }
            }
            h /= 3;
        }

        return a;
    }

    public static void main (String[] args) {
        Comparable[] a = generateTrial(50);
        Comparable[] sorted = SelectionSort.sort(a);
        System.out.println(Arrays.toString(sorted));
    }
}
