package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {90, -1, 2, 0, 6, 2, -4, 8,-100,900000,4,0,1};
        sort(a, 0, a.length - 1);
        for (int a1 : a) {
            System.out.print(a1 + ",");
        }

    }

    /**
     * The time complexity of below algoritham is : O(nlog(n)) TN =
     * T(N/2)+T(N/2)+T(N) = 2T(N/2)+T(N) by master theoram , it will be nlogn
     *
     * @param a
     * @param l
     * @param r
     */
    public static void sort(int[] a, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(a, l, m);// T(N/2)
            sort(a, m + 1, r);//T(N/2)
            merge(a, l, m, r);// T(N)
        }

    }

    /**
     * The time complexity of below algoritham in best case is O(nlogn) if array
     * already sorted and mid element is greater than the mid+1
     *
     * @param a
     * @param l
     * @param r
     */
    public static void sort1(int[] a, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            sort(a, l, m);// T(N/2)
            sort(a, m + 1, r);//T(N/2)
            if (a[m] > a[m + 1]) {
                merge(a, l, m, r);
            }
        }

    }

    public static void merge(int[] a, int l, int m, int r) {
        int n1 = m - l + 1; // calculate the length of the left subArray 
        int n2 = r - m; // Calculate the length of the right subArray
        int[] lArray = new int[n1];
        int[] rArray = new int[n2];
        for (int i1 = 0; i1 < n1; i1++) {
            lArray[i1] = a[l + i1];
        }

        for (int i2 = 0; i2 < n2; i2++) {
            rArray[i2] = a[m + i2 + 1];
        }

        int k = l;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (lArray[i1] < rArray[i2]) {
                a[k] = lArray[i1];
                i1++;
            } else {
                a[k] = rArray[i2];
                i2++;
            }
            k++;
        }

        while (i1 < n1) {
            a[k] = lArray[i1];
            i1++;
            k++;
        }

        while (i2 < n2) {
            a[k] = rArray[i2];
            k++;
            i2++;
        }

    }
}
