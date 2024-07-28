package sorting;

/**
 * IN bubble sort we will push the max element to the right in the array
 */

public class BubbleSorting {

    public static void main(String[] args) {
        int[] a = {64, 25, 12, 22, 11};
        a = bubbleSort(a);
        for (int x : a) {
            System.out.print(x + ",");
        }
    }

    /**
     * 1(n-1)+2*(n-2)+... n*(1) 1 + 2+3+4+5...n-1 TC : n*(n+1)/2 => n^2/2+n/2 ~=
     * o(n^2)
     *
     * @param a
     * @return
     */
    /**
     * The best time complexity will be if all the element in the array is
     * already sorted in the first time if any swap is not happening then, we
     * can cosider all the array is alreay sorted we can break the loop
     *
     * @param a
     * @return
     */
    private static int[] bubbleSort(int a[]) {
        /**
         * This will run from 1...n
         */
        for (int i = 0; i < a.length; i++) {
            int j = 0;
            /**
             * For each i , this will run from n-1..1
             */
            while (j < a.length - i - 1) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j + 1];
                    a[j + 1] = a[j];
                    a[j] = temp;
                }
                j++;
            }
        }
        return a;
    }
}
