package leetCode;

import java.util.Arrays;

public class LeetCode2448 {

    public static void main(String[] args) {
        int[] nums ={1,3,5,2};
        int[] cost = {2,3,1,14};
        System.out.println(minCost(nums, cost));
    }
    public static long minCost(int[] nums, int[] cost) {
        // Sort integers by values.
       int minCost = Integer.MAX_VALUE;
       for(int i=0;i<nums.length;i++){
            int c = 0;
            for(int j=0;j < nums.length;j++){
                c+=(Math.abs(nums[i] - nums[j]))*cost[j];
            }
            minCost = Math.min(minCost, c);
       }
       return minCost;
    }

    public int getMinCost(int[] nums,int[] cost,int ele){
        return 0;
    }
}
