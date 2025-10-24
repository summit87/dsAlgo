package leetCode;

import java.util.Stack;

public class LeetCode907 {
    public static void main(String[] args) {
        int[] a = { 1,3,1,2};
        System.out.println(sumOfMinInSubarray(a));
        // for (int c : findPreviousNextMinElemet(a)) {
        //     System.out.print(c + ",");
        // }
    }

    /**
     * There are multiple approach to find the sum of min element in all the
     * subarray
     * 1. We can use two nested loop to find the min element in. each subarray and
     * then sum the element
     * the time complexity of this subarray will ON^2
     * 2. Another approach is to calculate the number of sub array of each element
     * which contribute in minimum
     * the multiply that number with that element and sum the value
     * this approach we have mentioned below
     * 
     * eg = [3,1,2,4]
     * subArray :
     * 0,1,2,3 in this sub array minimum element is 1
     * 0,1,2 similarly in this subarray minimum is 1
     * 0,1 similarly in this sub array min is 1
     * 0 min is 3
     * 
     * 1,2,3 , min in this subarray is 1
     * 1,2, min is 1
     * 1 min is 1
     * 
     * 2,3 , min is 2
     * 2 , min is 2
     * 
     * 3 min is 4
     * 
     * if we see , then
     * 
     * 1 : this value is contributiting in 6 subarray,
     * [0...3],[0...2],[0..1][1...3],[1..2],[1]
     * similary for other element
     * 
     * so total sum : 1*6+2*2+3*1+4*1 => 17
     * 
     * 
     * 
     */
    private static int sumOfMinInSubarray(int[] a) {
        int sum = 0;
        int mod = 1000000000+7;
        int[] previousMinElement = findPreviousNextMinElemet(a);
        int[] nextSmallerElement = findNextSmallerElement(a);
        for (int i = 0; i < a.length; i++) {
            sum+= ((a[i]*previousMinElement[i]*nextSmallerElement[i])%mod);
        }
        return sum;
    }

    public static int[] findPreviousNextMinElemet(int[] a) {
        int[] val = new int[a.length];
        Stack<int[]> st = new Stack<>();
        for (int i = 0; i < a.length; i++) {
            if (st.isEmpty()) {
                st.push(new int[] { a[i], 1 });
                val[i] = 1;
                continue;
            }
            int cnt = 1;
            while (!st.isEmpty() && st.peek()[0] > a[i]) {
                cnt += st.pop()[1];
            }
            st.push(new int[] { a[i], cnt });
            val[i] = cnt;
        }
        return val;
    }

    public static int[] findNextSmallerElement(int[] a) {
        int[] val = new int[a.length];
        Stack<int[]> st = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--) {
            if (st.isEmpty()) {
                st.push(new int[] { a[i], 1 });
                val[i] = 1;
                continue;
            }
            int cnt = 1;
            while (!st.isEmpty() && st.peek()[0] >= a[i]) {
                cnt += st.pop()[1];
            }
            st.push(new int[] { a[i], cnt });
            val[i] = cnt;
        }
        return val;
    }
}
