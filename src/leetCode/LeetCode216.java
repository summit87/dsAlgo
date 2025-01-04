package leetCode;

import java.util.ArrayList;
import java.util.List;
/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.

 

Example 1:

Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.
Example 2:

Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.
 */
public class LeetCode216 {
    public static void main(String[] args) {
        int st = 1;
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> val = new ArrayList<>();
        int targetSum = 7;
        int k=3;
        combinationOfSum(st,0, targetSum, res, val, k);
        System.out.println(res);
    }


    public static void combinationOfSum(int st,int index,int targetSum,List<List<Integer>> res,List<Integer> val,int k){
        
        if(st >= 9){
            if(val.size() == k && targetSum == 0){
                res.add(new ArrayList<>(val));
            }
            return;
        }

        if(targetSum == 0 && val.size() == k ){
            /**
             * Simply res.add(val), will reset the array list val, , because at line 63 , if one by one
             * value at val will remove and resultant val.size will zero , due reference fo the same object in res , 
             * res will return empty.
             */
            res.add(new ArrayList<>(val));
            return;
        }

        if(targetSum >= st){
            val.add(st);
            combinationOfSum(st+1, index+1, targetSum-st, res, val, k);
            val.remove(val.size()-1);
        }
        combinationOfSum(st+1, index+1, targetSum, res, val, k);
    }
}
