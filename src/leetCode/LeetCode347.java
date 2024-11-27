package leetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/top-k-frequent-elements/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 * 
 * One catch in this problem is to undertand the top k most frequent element
 * e.k if k = 2, then
 * if in an array the total element we have 2 (may be unique or repeated) , then that is also called top k frequent element or
 * if in an array the total element we have 6, (some of the unique, not all the element are unique ) , 
 *          
 * 
 */

public class LeetCode347 {

    public static void main(String[] args) {
        int[] a = {1,3,4,4,6,6,8};int k = 2;
        for(int x : topKFrequent(a, k)){
            System.out.print(x+" ,");
        }
    }

    /**
     * First approach
     * The idea is to create a map and count the frequency of each element in array
     * then sort the map by value decending order, 
     * then create an array obeject of the len k and get top k element from map and store in that array and return
     * 
     * second approach , 
     * create an array of size(max-min+1) , why : we will end up with size of the array equal to number of unique element
     * and boolean array with same size and priorty queue (should be sorted in acending order)
     * 
     */


     public static int[] topKFrequent(int[] nums,int k){
       

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(min > nums[i]){
                min = nums[i];
            }

            if(max < nums[i]){
                max = nums[i];
            }
        }

        int[] count = new int[max - min + 1];
        final int min1 = min;
        boolean[] visited = new boolean[max-min+1];

        /**
         * This is good technique , 
         * 
         */
        PriorityQueue<Integer> pq = new PriorityQueue<>(extracted1(count, min1));

        for(int x : nums){
            count[x-min]++;
        }

        for(int num : nums){
            if(visited[num - min]){
                continue;
            }
            visited[num - min] = true;
            pq.add(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[] res = new int[pq.size()];
        for(int i=0;i < k;i++){
            res[i] = pq.poll();
        }


        return res;
     }

    private static Comparator<? super Integer> extracted1(int[] count, final int min1) {
        return (a,b) -> Integer.compare(count[a-min1],count[b-min1]);
    }

}
