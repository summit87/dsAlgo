package sorting;

public class StableSelectionSort {

    public static void main(String[] args) {
        int[] a = {4, 5, 3, 2, 4, 1};
        stableSort(a);
    }

    public static void stableSort(int[] a) {

        for (int i = 0; i < a.length; i++) {
            int min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }

            int k = min;
            int val = a[min];
            for (int l = k; l > i; l--) {
                a[l] = a[l - 1];
            }
            a[i] = val;
        }

        for (int d : a) {
            System.out.print(d + ",");
        }

    }
}
