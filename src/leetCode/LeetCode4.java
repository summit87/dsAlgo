package leetCode;

public class LeetCode4 {
    public static void main(String[] args) {
        int[] a1 = { 1 };
        int[] a2 = { 2 };
        System.out.println(findMedianUsingBinarySearch(a1, a2));
    }

    private static float median(int[] a1, int[] a2) {
        float m1 = -1;
        float m2 = -1;
        int c = (a1.length + a2.length) / 2;
        int i = 0;
        int j = 0;
        for (int c1 = 0; c1 <= c; c1++) {
            if (i < a1.length && j < a2.length) {
                if (a1[i] < a2[j]) {
                    m1 = a1[i];
                    i++;
                } else if (a1[i] > a2[j]) {
                    m2 = a2[j];
                    j++;
                }
            }
        }

        if (i == a1.length) {
            m2 = a2[0];
        } else if (j == a2.length) {
            m1 = a1[0];
        }

        if ((a1.length + a2.length) % 2 == 1) {
            return m1;
        }

        return (m1 + m2) / 2;

    }

    public static float findMedianUsingBinarySearch(int[] num1, int[] num2) {
        if (num1.length >= num2.length) {
            return median(num2, num1, 0, num2.length-1);
        }
        return median(num1,num2,0,num1.length-1);

    }

    private static float median(int[] a, int[] b, int left, int right) {
        if(left > right){
            return 0.0f;
        }

        int aLeft = a.length-1;
        int bRight = b.length-1;
        int midA = left+((right-left)/2);

        /**
         * The reason to calculate the mid of array b in this way is to make sure that the entire array(After merging should sepearate),
         * i,e max in left <= min in right
         * https://chatgpt.com/c/68faccaf-24cc-8320-8011-d6f8cb9df2ea
         */
        int midB = aLeft+((bRight-aLeft)/2) - midA;
        int aMin=a[midA];
        int bMin = b[midB];
        int aMax = Integer.MAX_VALUE;
        if(midA+1 < a.length){
            aMax = a[midA+1];
        }
        int bMax = Integer.MAX_VALUE;
        if(midB+1 < b.length){
            bMax = b[midB+1];
        }

        if(aMin <= bMax && bMin <= aMax){
            int totalLength = (a.length+b.length) % 2;
            if(totalLength == 0){
                int val = Math.min(aMin, bMax)+Math.min(bMin, aMax);
                return (float)val/2;
            }

            /**
             * Why this calculation
             * Consider as situation when we are dealing with two sorted array and one of them len is smaller than the other
             * Other array are sorted and all the elements are smaller than the first element of other element, then last element of one array will be 
             * max and first element of the 2nd array will be smaller. so
             * avg = Max(last element of first array, first element of 2nd array)
             */
            int val = Math.min(aMax, bMin);
            return (float)val/2;
        }

        if(aMin > bMax){
            return median(a, b,left,midA-1);
        }

        return median(a, b,midA+1,right);

        

    }

}
