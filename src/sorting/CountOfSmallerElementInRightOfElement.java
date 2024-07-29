package sorting;

public class CountOfSmallerElementInRightOfElement {

    public static void main(String[] args) {
        int[] a = {6, 3, 7, 2} ;
        int[] count = new int[a.length];
        rightSmaller(a, 0, a.length-1, count);
        for(int c : count){
            System.out.print(c+",");
        }
    }

    public static void countSmaller(int[] a, int l, int m, int r, int[] count) {
        int n1 = m - l + 1;
        int n2 = r - m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        int cnt = 0;
        for (int i1 = 0; i1 < n1; i1++) {
            left[i1] = a[l + i1];
        }
        for (int i2 = 0; i2 < n2; i2++) {
            right[i2] = a[m + i2 + 1];
        }

        int k = l;
        int i1 = 0;
        int i2 = 0;
        while (i1 < n1 && i2 < n2) {
            if (left[i1] < right[i2]) {
                a[k] = left[i1];
                i1++;
            } else {
                a[k] = right[i2];
                cnt += (m + 1) - (l + i1);
                i2++;
            }
            k++;
        }
        count[m-l-1]+=cnt;
        while (i1 < n1) {
            a[k] = left[i1];
            i1++;
            k++;
        }

        while (i2 < n2) {
            a[k] = right[i2];
            i2++;
            k++;
        }
    }

    public static void rightSmaller(int[] a, int l, int r, int[] count) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        rightSmaller(a, l, mid, count);
        rightSmaller(a, mid + 1, r, count);
        countSmaller(a, l, mid, r, count);
    }
}
