package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode930 {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
          System.out.println(subArrayCount(nums, goal));
       // int count = findSubarrayCount(nums,goal);
        //System.out.println(count);
    }

    private static int findSubarrayCount(int[] nums,int goal){
        int count = 0;
        int index = 0;
        int sum=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(index = 0;index < nums.length;index++){
            sum+=nums[index];
            if(sum == goal){
                count++;
            }

            if(map.containsKey(sum - goal)){
                count+=map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return count;
    }

    /** source lc
     * For a more efficient approach, let's consider aspects of the problem: We must achieve a goal using subarrays.
     *  We can't pick elements individually. Problems with these qualities are often solved using the sliding window pattern.

In a standard sliding window approach, once the currentSum reaches the target goal, the typical strategy involves simply moving the
 left pointer of the window forward to potentially find more subarrays. However, this approach has a critical limitation when applied to binary arrays.

Including a zero element in the subarray won't change the sum. As a result, even if the currentSum reaches the goal initially,
 we might miss further subarrays that also meet the goal by simply shrinking the window as long as the sum remains equal to the goal.
  This is because the presence of zeros creates the possibility of combining them with elements encountered later to reach the target sum. for example


  let say : a = {1,0,1,0,1,0,0,1,1}; goal: 2,  we have included the array element in currentSum from 0 to 3, which give us currentSum = goal, now we 
  will try to reduce the window (since next element give us current sum more than the goal),
   so we will reduce window from left till we are not getting sum equal to goal , so now in this case we will move left till index 1, and we move right index from 3 - 6 
   (since we will get current sum equal to goal), now if we carefuly observed , we are removing index 1 from subarray and that should not happen, since if we traverse from index 
   1 to 6, we will get the currentSum equal to goal, thats the region reducing from left and moving to right won't be working.



Thus subarrays exceeding the target sum are irrelevant to our objective. We only care about subarrays whose sum is either equal to the goal or less than the goal.

Leveraging this insight, we can directly track the number of subarrays with a sum at most equal to the goal.

After calculating the total count of subarrays with sums less than or equal to the goal using the functionslidingWindowAtMost(nums, goal),
 we need to isolate the subarrays that strictly meet the target goal.

This can be achieved by subtracting the total count of subarrays with sums less than the goal (slidingWindowAtMost(nums, goal - 1))
 from the total count obtained earlier. By subtracting the latter from the former, we remove the subarrays that don't reach the goal 
 and are left with only the subarrays that have a sum exactly equal to the goal.

Refer to the visual slideshow demonstrating the sliding window on slidingWindowAtMost(nums, goal).
     */



     private static int subArrayCount(int[] nums,int goal){
        int totalCount = 0;
        int left = 0;
        int right = 0;
        int currentSum = 0;
        while(right < nums.length){
            currentSum+=nums[right];
            while(left < right && currentSum > goal){
                currentSum-=nums[left];
                left++;
            }
            totalCount+=right-left+1;
            right++;
        }

        return totalCount;
     }



}
