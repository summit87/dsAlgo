package binarySearch;

public class Pivot1 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(2 >> 9);
      //  System.out.println(findPivot(nums, 0, nums.length-1));
    }


    public static int findPivot(int[] nums,int left,int right){
        if(left >= right){
            return -1;
        }
        int mid = left+(right-left)/2;
        if(mid+1 <= right && nums[mid] > nums[mid+1]){
            return mid+1;
        }

        if(mid - 1>= 0 && nums[mid] < nums[mid-1]){
            return mid;
        }

        if(nums[mid] > nums[left]){
            return findPivot(nums, mid+1, right);
        }
        return findPivot(nums, mid-1, left);
    } 
}
