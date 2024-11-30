package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/maximum-frequency-of-an-element-after-performing-operations-i/description/?envType=company&envId=google&favoriteSlug=google-thirty-days
 */

/**
 * Example 1:
 * 
 * Input: nums = [1,4,5], k = 1, numOperations = 2
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * We can achieve a maximum frequency of two by:
 * 
 * Adding 0 to nums[1]. nums becomes [1, 4, 5].
 * Adding -1 to nums[2]. nums becomes [1, 4, 4].
 * Example 2:
 * 
 * Input: nums = [5,11,20,20], k = 5, numOperations = 1
 * 
 * Output: 2
 * 
 * Explanation:
 * 
 * We can achieve a maximum frequency of two by:
 * 
 * Adding 0 to nums[1].
 */
public class LeetCode3346 {
    public static void main(String[] args) {
        int[] nums = {1,4,5};
        int k = 1;
        int numOps = 2;

        System.out.println(minimumOperation1(nums, k, numOps));
       
    }

    /**
     * Approach - 1 ,
     * Here we finding minimum and maximum and then we are traversing in all the index b/w min and max
     * @param nums
     * @param k
     * @param numOps
     * @return
     */

    private static int minimumOperation(int[] nums,int k,int numOps){

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            min = Math.min(min, nums[i]-k);
            max = Math.max(max, nums[i]+k);
            map.put(nums[i] - k, map.getOrDefault(nums[i] - k,0)+1);
            map.put(nums[i] + k + 1, map.getOrDefault(nums[i]+k+1, 0)-1);
        }

        int res = 1;
        
        for(int i=min;i<=max;i++){
            int prefix = map.getOrDefault(i-1,0)+map.getOrDefault(i,0);
            if(!freqMap.containsKey(i)){
                map.put(i, prefix);
                continue;
            }

            map.put(i, prefix);
            
            int count = map.get(i);
            int freCount = freqMap.getOrDefault(i,0);
            int actualModifiedCount = count - freCount;
            int res1 = Math.min(actualModifiedCount, numOps);
            res1+=freCount;
            res = Math.max(res1, res);
        }
        //System.out.println(map);
        return res;
    }



    private static int minimumOperation1(int[] nums,int k,int numOps){

        Map<Integer, Integer> map = new LinkedHashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
            min = Math.min(min, nums[i]-k);
            max = Math.max(max, nums[i]+k);
            map.put(nums[i] - k, map.getOrDefault(nums[i] - k,0)+1);
            map.put(nums[i] + k + 1, map.getOrDefault(nums[i]+k+1, 0)-1);
            map.put(nums[i], map.getOrDefault(nums[i],0)+0);
        }

        int res = 1;
        int previousCount = 0;

        for(Map.Entry<Integer,Integer> m1 : map.entrySet()){
            int val = m1.getValue()+previousCount;
            
            map.put(m1.getKey(), val);
            previousCount  = val;
            
            int frequencyCount = freqMap.getOrDefault(m1.getKey(),0);
            int finalCount = val-frequencyCount;
            int res1 = Math.min(finalCount, numOps);
            res1+=frequencyCount;
            res = Math.max(res, res1);
        }
        //System.out.println(map);
        return res;
    }

    /**
     * Check the below approach , sliding window
     * 
     *  public int maxFrequency(int[] nums, int k, int numOperations) {
        int max = 0;
        for(int e: nums) {
            max = Math.max(max, e);
        }
        int[] freq = new int[max+1];
        for(int e: nums) {
            freq[e]++;
        }
        int total = 0;
        for(int i=0; i<Math.min(k,max+1); ++i) {
            total+=freq[i];
        }
        int res = 0;
        for(int i=0; i<=max; ++i) {
            if(i+k<=max) {
                total+=freq[i+k];
            }
            res = Math.max(res, freq[i] + Math.min(numOperations, total-freq[i]));
            if(i-k>=0) {
                total-=freq[i-k];
            }
        }
        return res;
    }
     */
}
