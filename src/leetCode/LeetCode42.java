package leetCode;

import java.util.Stack;

public class LeetCode42 {
    public static void main(String[] args) {
        int[] a = {0,1,0,2,1,0,1,3,2,1,2,1};
        Stack<Integer> st = new Stack<>();
        int totalWater = 0;
        int current = 0;
        while(current < a.length){
            while (!st.isEmpty() && a[current] > a[st.peek()]) {
                int top = st.pop();
                if (st.isEmpty()) {
                    break;
                }

                int dist = current - st.peek()-1;
                int height= Math.min(a[current], a[st.peek()]) - a[top];
                totalWater += (dist*height);
            }
            st.push(current);
            current++;
        }
        System.out.println(totalWater);
    }


}
