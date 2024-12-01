package leetCode;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=company&envId=google&favoriteSlug=google-thirty-days&difficulty=MEDIUM%2CEASY
 */
public class LeetCode35 {
    public static void main(String[] args) {

        int[] a = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int index = getTargetIndex(a, target, 0, a.length - 1);
        int index1 = -1;
        if(index+1 < a.length && a[index+1] != target){
            index1 = getTargetIndex(a, target, 0, index-1);
        }else{
            index1 = getTargetIndex(a, target, index+1, a.length-1);
        }
        System.out.println(index1);

    }

    private static int getTargetIndex(int[] nums, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;
        if (((mid - 1 >= 0 && nums[mid - 1] != target) || (mid + 1 <= right && nums[mid + 1] != target))
                && nums[mid] == target) {
            return mid;
        }
        if (target > nums[mid]) {
            return getTargetIndex(nums, target, mid + 1, right);
        }
        return getTargetIndex(nums, target, left, mid - 1);
    }
}
