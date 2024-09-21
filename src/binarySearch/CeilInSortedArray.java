package binarySearch;

public class CeilInSortedArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 8, 10, 10, 12, 19};
        System.out.println(ceil(a, 0, a.length - 1, 7));
    }
/**
 * For example, let the input array be {1, 2, 8, 10, 10, 12, 19}
For x = 0:    floor doesn't exist in array,  ceil  = 1
For x = 1:    floor  = 1,  ceil  = 1
For x = 5:    floor  = 2,  ceil  = 8

 * @param a
 * @param left
 * @param right
 * @return
 */
    private static int ceil(int[] a,int left,int right,int x){
        if(left > right){
            return -1;
        }

        if(a[left] >= x){
            return left;
        }

        if(a[right] == x){
            return right;
        }

        int mid = left + (right-left)/2;

        if(a[mid] == x){
            return mid;
        }

        // if(mid-1 >= left && a[mid-1] < x && x < a[mid]){
        //     return mid;
        // }

        if(a[mid] < x){
            if(mid+1 <= right && x < a[mid+1]){
                return mid+1;
            }
            return ceil(a, mid+1, right, x);
        }

        if(mid -1 >= left && a[mid-1] < x){
            return mid;
        }
        return ceil(a, left, mid-1, x);

    }
}
