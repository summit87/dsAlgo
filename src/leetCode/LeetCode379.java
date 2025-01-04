package leetCode;

import java.util.*;
public class LeetCode379 {
    public static void main(String[] args) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        int targetSum = 4;
        int[] a = {1,2,3};
        
        System.out.println(combinationSum4(targetSum, 0, a));
    }

    public static int combinationSum4(int target,int index,int[] arr){
        if(target == 0){
            return 1;
        }

        if(index >= arr.length || target < 0){
           
            return 0;
        }

       

        return combinationSum4(target - arr[index], index, arr) + combinationSum4(target, index+1, arr);
        
    }
}
