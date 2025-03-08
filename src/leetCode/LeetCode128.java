package leetCode;

public class LeetCode128 {
    public static void main(String[] args) {
        int[] num = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(num));
    }

    public static int longestConsecutive(int[] nums) {
        // Arrays.sort(nums);
        sort(nums, 0, nums.length - 1);
        
        int maxLen = 1;
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                if(nums[i] == nums[i-1]+1){
                    cnt++;                    
                }else{
                    maxLen = Math.max(cnt,maxLen);
                    cnt = 1;
                }
            }
        }
        return maxLen;
    }

    public static int pivot(int[] a, int left, int right) {
        int p = a[right];
        int l = left - 1;
        int r = left;
        for (; r <= right; r++) {
            if (p > a[r]) {
                l++;
                int temp = a[l];
                a[l] = a[r];
                a[r] = temp;
            }

        }

        int temp = a[l + 1];
        a[l + 1] = p;
        a[right] = temp;
        return l + 1;
    }

    public static void sort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int p = pivot(a, left, right);
        sort(a, left, p - 1);
        sort(a, p + 1, right);
    }
}
