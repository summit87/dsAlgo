package array;

import java.util.*;;

public class MaxLenghtOfSubArray {
    public static void main(String[] args) {
        int[] a = { 10, 5, 7, 2, 1, 9 };
        int sum = 15;

        int[] a1 = {-5, 8, -14, 2, 4, 12};
        int sum1 = -5;
        System.out.println(maxLen(a1, sum1));
    }

    /**
     * ON2 : we can use two loop, first loop will be used for traversing the
     * complete array
     * : 2nd array will be used for traversing to sub array and calculating the sum
     * 
     * 
     */

    /**
     * We will be using O(N), we will be using prefixSum and map
     */

    public static int maxLen(int[] a, int sum) {
        int mxLen = Integer.MIN_VALUE;
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            prefixSum += a[i];
            if (prefixSum == sum) {
                mxLen = Math.max(mxLen, i + 1);
            } else if (map.containsKey(prefixSum - sum)) {
                mxLen = Math.max(mxLen, i - map.get(prefixSum - sum));
            } else {
                map.put(prefixSum, i);
            }
        }
        return mxLen;
    }
}
