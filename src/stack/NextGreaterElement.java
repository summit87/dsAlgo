package stack;

import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        for(int x : res(a)){
            System.out.print(x+",");
        }
    }

    public static int[] res(int[] a){
        int[] re = new int[a.length];
        Stack<Integer> st = new Stack<>();
        for(int x = a.length-1;x >= 0 ;x--){
            if(st.isEmpty()){
                re[x] = -1;
                st.push(x);
                continue;
            }
            while(!st.isEmpty() && a[st.peek()] < a[x]){
                st.pop();
            }
            re[x] = !st.isEmpty() ? a[st.peek()] : -1;
            st.push(x);
        }
        return re;
    }
}
