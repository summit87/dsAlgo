package linkedin;
/**
 * Partition
 */
public class LeetCode416 {
    public static void main(String[] args) {
        int[] nums = {2,2,3,5};
        System.out.println(isPartition(nums));
    }

    public static  boolean isPartition(int[] nums){
        
        
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        if(sum %2 != 0){
            return false;
        }
        int sum1 = sum/2;
        boolean[] dp = new boolean[sum1+1];
        dp[0] = true;
        for(int i=1;i<=nums.length;i++){
            for(int j=nums[i-1];j<=sum1;j++){
                dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        return dp[sum1];
    }
}
