package linkedin;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1004 {
    public static void main(String[] args) {
        int[] a = { 0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int maxLen = Integer.MIN_VALUE;
        int st = 0;
        int k = 3;
        int end = 0;
        Queue<Integer> q = new LinkedList<>();
        /**
         * Q :  3,4,5 , i = 5;
         * st = 4
         * i-st+1 = 2 , maxLen = 5
         * 
         * i = 9;st = 4
         * 9 - 4+1 : 6
         * 
         * i =10;
         * st = 5
         * 10-5+1 : 6
         */
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                q.add(i);
            }
            if (q.size() > k) {
                st = q.poll() + 1;
            }
            if(i - st + 1 > maxLen){
                maxLen = i - st + 1;
                end = i;
            }
        }
        System.out.println((st-1)+" : "+end);
        System.out.println(maxLen);
    }
}
