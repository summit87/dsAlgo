package array;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        // arr1[] = {1, 12, 15, 26, 38,50}, arr2[] = {2, 13, 17, 30, 45,90}
        int[] a1 = { 1, 12, 15, 26, 38, 50 ,60};
        int[] a2 = { 2, 13, 17, 30, 45, 90 ,130};
        System.out.println(medianOfTree(a1, a2));
        System.out.println(median(a1, a2));

    }

    private static int median(int[] a1, int[] a2) {
        int median = 0;
        int[] a3 = new int[a1.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a3.length) {
            if (j < a1.length && a1[j] < a2[k]) {
                a3[i] = a1[j];
                i++;
                j++;
            } else {
                a3[i] = a2[k];
                k++;
                i++;
            }
        }
        int mid = a3.length / 2;
        System.out.println(a3[mid]+" : "+a3[mid-1]);
        return (a3[mid] + a3[mid - 1]) / 2;
    }

    private static int medianOfTree(int[] a1, int[] a2) {
        int low = 0;
        int highe = a1.length;
        while (low <= highe) {
            int mid1 = low + (highe - low) / 2;
            int mid2 = a2.length - mid1;
            int l1 = mid1 == 0 ? Integer.MIN_VALUE : a1[mid1-1];
            int r1 = mid1 == a1.length ? Integer.MAX_VALUE : a1[mid1];
            int l2 = mid2 == 0 ? Integer.MIN_VALUE : a2[mid2-1];
            int r2 = mid2 == a2.length ? Integer.MAX_VALUE : a2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                System.out.println(l1+" "+r1+" : "+l2+" : "+r2);
                return (Math.max(l1, l2) + Math.min(r2, r1)) / 2;
            }
            if (l1 > r2) {
                highe = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return 0;
    }
}
