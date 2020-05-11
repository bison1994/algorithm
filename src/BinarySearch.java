package src;

public class BinarySearch {
    public int rank (int key, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (hi > lo) {
            int pointer = (lo + hi) / 2;
            if (arr[pointer] == key) {
                return pointer;
            }
            if (arr[pointer] > key) {
                hi = pointer;
            } else {
                lo = pointer;
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = { 1, 3, 4, 9, 12, 20 };
        int r1 = bs.rank(1, arr);
        int r2 = bs.rank(0, arr);

        System.out.println(r1 > -1);
        System.out.println(r2 > -1);
    }
}
