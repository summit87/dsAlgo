package binarySearch;

public class SearchElementInSortedArray {
    public static void main(String[] args) {
        int[] a = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};
        int k = 212;
        // System.out.println(binarySearch(a, k, 0, a.length - 1));
         System.out.println(binarySerachInLoop(a, k));
    }

    private static int binarySearch(int[] a, int k, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (a[left] == k) {
            return left;
        }

        if (a[right] == k) {
            return right;
        }

        int mid = left + ((right - left) / 2);
        if (a[mid] == k) {
            return mid;
        }

        if (k < a[mid]) {
            return binarySearch(a, k, left, mid - 1);
        }
        return binarySearch(a, k, mid + 1, right);

    }

    private static int binarySerachInLoop(int[] a,int k){

        int left = 0;
        int right = a.length-1;
        while(left <= right){
            if(a[left] == k){
                return left;
            }
            if(a[right] == k){
                return right;
            }

            int mid = left + ((right - left)/2);
            if(a[mid] == k){
                return mid;
            }

            if(k < a[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        return -1;
    }
}
