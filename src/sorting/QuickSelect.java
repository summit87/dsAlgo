package sorting;

public class QuickSelect {
    public static void main(String[] args) {

        int[] a = { 10, 5, 2, 90, -9, 100, 4, 7 };
        int k = 3;
        int k1 = quickSelect(a, 0, a.length - 1, k);
        if (k1 >= 0 && k1 <= k) {
            System.out.println(a[k1]);
        }
    }

    private static int quickSelect(int[] a, int l1, int r1, int k) {
        if (l1 > r1) {
            return -1;
        }

        if (l1 == r1) {
            return l1;
        }

        int p = pivot(a, l1, r1);
        if (p > k) {
            return quickSelect(a, l1, p - 1, k);
        }
        return quickSelect(a, p + 1, r1, k);

    }

    private static int pivot(int[] a, int l, int r) {
        int p = a[r];
        int l1 = l - 1;
        int r1 = l;

        for (; r1 <= r; r1++) {
            if (p > a[r1]) {
                l1++;
                int temp = a[l1];
                a[l1] = a[r1];
                a[r1] = temp;
            }
        }

        l1++;
        if (l1 < a.length) {
            int temp = a[l1];
            a[l1] = p;
            a[r] = temp;
        }
        return l1;
    }
}
