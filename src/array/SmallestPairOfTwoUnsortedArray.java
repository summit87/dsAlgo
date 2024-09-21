package array;

public class SmallestPairOfTwoUnsortedArray {
    public static void main(String[] args) {
        int[] a = { 1, 3, 15, 11, 2 };
        int[] b = {23, 127, 235, 19, 8};
        quickSort(a, 0, a.length - 1);
        quickSort(b, 0, a.length-1);
        int[] pair = findPair(a, b);
        System.out.println(pair[0]+" : "+pair[1]);
    }


    private static int[] findPair(int[] a,int[] b){
        int result = Integer.MAX_VALUE;
        int al = 0;
        int bl = 0;
        int[] pair = new int[2];
        while (al < a.length && bl < b.length) {
            if(Math.abs(a[al] - b[bl]) < result){
                result = Math.abs(a[al] - b[bl]);
                pair[0] = a[al];
                pair[1] = b[bl];
            }
            if(a[al] > b[bl]){
                bl++;
            }else{
                al++;
            }
        }
        return pair;
    }

    private static void quickSort(int[] a, int left, int right) {
        if (left > right) {
            return;
        }

        int pivot = findPivot(a, left, right);
        quickSort(a, left, pivot - 1);
        quickSort(a, pivot + 1, right);

    }

    /**
     * {1, 3, 15, 11, 2}
     * 
     * @param a
     * @param left
     * @param mid
     * @param right
     * @return
     */

    /**
     * In quick sort , we first select the pivot
     * we will try to put all the element left of the pivot
     * which is less than the pivot and all the element right
     * which is greater than the pivot
     * 
     */
    private static int findPivot(int[] a, int left, int right) {

        int p = a[right];
        int i = left - 1;
        int j = left;
        while (j < right) {
            if (p > a[j]) {
                i++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
            j++;
        }
        int temp = a[i+1];
        a[i+1] = a[j];
        a[j] = temp;
        return i+1;
    }
}
