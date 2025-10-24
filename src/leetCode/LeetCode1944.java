package leetCode;

import java.util.Stack;

public class LeetCode1944 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5};
        for (int a1 : result(a)) {
            System.out.print(a1 + ",");
        }
    }

 
    public static int[] getResult(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                boolean flag = true;
                for (int k = i + 1; k < j; k++) {
                    if(!(a[k] < Math.min(a[i], a[j]))){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    result[i]++;
                }
            }
        }
        return result;
    }

       /**
     * Input: heights = [10,6,8,5,11,9]
     * Output: [3,1,2,1,1,0]
     */

    public static int[] result(int[] a){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[a.length];
        st.push(a[a.length-1]);
        for(int i = a.length-2;i>=0;i--){
            if(st.isEmpty()){
                st.push(a[i]);
                continue;
            }
            int cnt=0;
            while(!st.isEmpty() && st.peek() < a[i]){
                cnt++;
                st.pop();
            }
            res[i] = cnt;
            if(!st.isEmpty() && st.peek() > a[i]){
                res[i] ++;
            }
            st.push(a[i]);
        }
        return res;
    }
}
