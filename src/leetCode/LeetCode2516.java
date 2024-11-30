package leetCode;

import java.util.Arrays;

public class LeetCode2516 {
    static int minutes = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int minute = 0;
        int k = 1;
        String str = "a";
        int left = 0;
        int right = str.length() - 1;
        int[] count = new int[3];

        // minimumK(str, left, right, count, minute, k);
        System.out.println(minutes(str,k));

    }

    /**
     * We will be using sliding window technique
     * 1. First we will compute the largest window which doesn't contribute into k
     * count of each character
     * the count of all the character i.e a, b and c should be outside the maximun
     * window
     * 
     * @param str
     * @param k
     * @return
     */

     /**
      * aabaaaacaabc
      * @param str
      * @param k
      * @return
      */

    private static int minutes(String str, int k) {
        int res = 0;

        int[] count = new int[3];
        int[] countAtCurrentPoint = new int[3];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }

        for(int i=0;i<count.length;i++){
            if(count[i] < k){
                return -1;
            }
        }

        int left = 0;
        int right = 0;


        int maxWindow = Integer.MIN_VALUE;
        while (right < str.length()) {
            countAtCurrentPoint[str.charAt(right) - 'a']++;
            while (left <= right) {
                if (count[0] - countAtCurrentPoint[0] < k || count[1] - countAtCurrentPoint[1] < k
                        || count[2] - countAtCurrentPoint[2] < k) {
                    
                    countAtCurrentPoint[str.charAt(left) - 'a']--;
                    left++;
                    continue;
                }
                break;
                
            }

            maxWindow = Math.max(maxWindow, right - left + 1);
            right++;
        }

        return maxWindow != Integer.MIN_VALUE ? str.length() - maxWindow : 0;
    }

    /**
     * This the recursion approach , since we are dividing recursion in two diffrent
     * part
     * 1. first we are going towards left
     * 2. 2nd we are going towards right
     * then total TC is 2^n ()
     * 
     * @param str
     * @param left
     * @param right
     * @param count
     * @param minute
     * @param k
     */

    public static void minimumK(String str, int left, int right, int[] count, int minute, int k) {
        if (count[0] >= k && count[1] >= k && count[2] >= k) {
            minutes = Math.min(minutes, minute);
            return;
        }

        if (left > right) {
            return;
        }

        int[] count11 = Arrays.copyOf(count, count.length);
        count11[str.charAt(left) - 'a']++;
        minimumK(str, left + 1, right, count11, minute + 1, k);

        int[] count1 = Arrays.copyOf(count, count.length);
        count1[str.charAt(right) - 'a']++;
        minimumK(str, left, right - 1, count1, minute + 1, k);
    }

}
