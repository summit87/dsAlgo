package binarySearch;

public class FindPivotInSortedRotatedArray {
    public static void main(String[] args) {
        int[] a = {4, 5, 6, 7,1};
        System.out.println(findPivot(a));
    }

    /**
     * arr[] = {4, 5, 6, 7, 0, 1, 2}, key = 0
     * @param a
     * @return
     */
    private static int findPivot(int[] a){
        int low = 0;
        int highe = a.length-1;

        while(low <= highe){
            if(a[low] < a[highe]){
                return low;
            }
            int mid = low + ((highe - low)/2);
            if(a[mid] < a[highe]){
                highe = mid;
            }else{
                low = mid+1;
            }
        }

        return low;
    }


}
