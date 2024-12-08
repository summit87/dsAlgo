package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/find-k-closest-elements/description/?envType=problem-list-v2&envId=sliding-window
 * 
 * An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3

Output: [1,2,3,4]

Example 2:

Input: arr = [1,1,2,3,4,5], k = 4, x = -1

Output: [1,1,2,3]
 */
public class LeetCode658 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        int k = 5;
        int x = 4;
        System.out.println(closerElement(a, k, x));
    }


    private static List<Integer> closerElement(int[] a,int k,int x){
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<a.length;i++){
          
            if(!pq.isEmpty() && pq.size() > k && pq.peek() > (int)Math.abs(x-a[i])){
                pq.poll();
            }else if(pq.size() < k){
                pq.add(Math.abs(x - a[i]));
            }
        }

        while(!pq.isEmpty()){
            list.add(pq.poll());
        }
        return list;
    }
}
