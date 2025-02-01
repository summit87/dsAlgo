
package leetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode2158 {
    public static void main(String[] args) {
        int[] nums = {1,1,0,0};
        System.out.println(maxScoreIndices(nums));
    }

     public static List<Integer> maxScoreIndices(int[] nums) {
        int numsOf1s = 0;
        List<Integer> indexes = new ArrayList<>();
        Integer index = -1;
        for(int i=nums.length-1;i>=0;i--){
            if(nums[i] == 1){
                numsOf1s++;
                index = i;
            }
        }
        
        Map<Integer,List<Integer>> map = new HashMap<>();
        indexes.add(index);
        map.put(numsOf1s,indexes);
        int numsOf0s=0;
        Integer mx = Integer.MIN_VALUE;
        mx = numsOf1s;
        for(int i=0;i<nums.length;i++){

            if(nums[i] == 0){
                numsOf0s++;
            }else if(nums[i] == 1){
                numsOf1s--;
            }
            int score = numsOf0s+numsOf1s;
            mx = Math.max(score,mx);
          
            if(map.containsKey(score)){
                List<Integer> ind = map.get(score);
                int val = i+1;
                ind.add(val);
                map.put(score,ind);
            }else{
                List<Integer> ind = new ArrayList<>();
                int val = i+1;
                ind.add(val);
                map.put(score,ind);
            }
            
        }
        return map.get(mx);
    }
}
