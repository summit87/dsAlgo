package leetCode;

public class LeetCode2040 {

    public static void main(String[] args) {
        int[] nums1 = { 2, 5 };
        int[] nums2 = { 3, 4 };
        int k = 2;
        System.out.println(result(nums1, nums2, k));
    }

    public static long result(int[] nums1, int[] nums2, int k) {
        long left = -25l; // -1e10
        long right = 25l; // 1e10
        int count = 0;
        long res = 0l;
        while (left <= right) {
            long mid = left+((right - left) / 2);
            count = getIndex(nums1, nums2, mid);
            if (count >= k) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;

    }

    public static int getIndex(int[] nums1, int[] nums2, long target) {

        int count = 0;
        
        for (int n1 : nums1) {

            if (n1 >= 0) {
                int left = 0;
                int right = nums2.length - 1;
                int p = -1;
                while (left <= right) {
                    int mid = left + ((right - left) / 2);
                    long product = n1 * nums2[mid];
                    if (product <= target) {
                        p = mid;
                        left = mid + 1;
                    } else {
                        right = mid-1;
                    }
                }
                count+=(p+1);
            }else{
                 int left = 0;
                int right = nums2.length - 1;
                int p = -1;
                while (left <= right) {
                    int mid = left + ((right - left) / 2);
                    int product = n1 * nums2[mid];
                    if (product <= target) {
                        p = mid;
                        left = mid + 1;
                    } else {
                        right = mid-1;
                    }
                }
                count+=(nums2.length-1 - p);
            }
        }
        return count;

    }

}
