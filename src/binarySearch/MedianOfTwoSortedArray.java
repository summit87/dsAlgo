package binarySearch;

public class MedianOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
       System.out.println((3%4)+" : "+(3/3));
    }

    public static double medianOfSorted(int[] nums1,int[] nums2){
        
        int left = 0;
        int right = nums1.length-1;
        int n1 = nums1.length - 1;
        int n2 = nums2.length - 1;
        while(left < right){
            int mid = left+((right-left)/2);
            int l1 = nums1[mid];int r1 = nums1[mid+1];
            int l2 = nums2[n2-mid];int r2 = nums2[n2-mid+1];
            if(l1 < r2 && l2 < r1){
                return (Math.min(l1, r2) + Math.min(l2, r1))/2;
            }

            if(l1 > r2){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return 0.0;
    }
}
