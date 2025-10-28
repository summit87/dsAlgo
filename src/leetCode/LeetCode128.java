package leetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LeetCode128 {
    public static void main(String[] args) {
        int[] num = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutiveSeq(num));
    }


    public static int longestConsecutiveSeq(int[] a){
        int cnt = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++){
            int cnt1 = 1;
            if(map.containsKey(a[i])){
                cnt1+=map.get(a[i]);
            }
            map.put(a[i], cnt1);
        }
        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<a.length;i++){
            int num = a[i];
            int val = 0;
            while(map.containsKey(num)){
                if(visited.contains(num)){
                    val+=map.get(num);
                    break;
                }
                visited.add(num);
                val+=map.get(num);
                num++;
            }

            cnt = Math.max(cnt, val);
            
        }

        return cnt;
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
