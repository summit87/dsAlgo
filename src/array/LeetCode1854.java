package array;

/**
 * Maximum population of the recent year
 *https://leetcode.com/problems/maximum-population-year/description/
 */
public class LeetCode1854 {

    public static void main(String[] args) {
        int[][] logs =  {{1993,1999},{2000,2010}};
        /**
         * Since it is given in the code max year we can take upto 2050
         */

        int[] arr = new int[2050 + 1];
        int max = Integer.MIN_VALUE;
        int recentYear = 0;
        for (int i = 0; i < logs.length; i++) {
            for (int j = logs[i][0]; j <= logs[i][1]; j++) {
                int count = 0;
                if (j == logs[i][1]) {
                    count = arr[j-1] - 1;
                } else {
                    count = arr[j] + 1;
                }
                arr[j] = count;
                if (max < count) {
                    max = count;
                    recentYear = logs[i][0];
                }
            }
        }

        System.out.println(recentYear);
    }
}
