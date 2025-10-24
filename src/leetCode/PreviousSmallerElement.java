package leetCode;

import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] a = {34, 35, 27, 42, 5, 28, 39, 20, 28 };
        for(int x : prevSmaller(a)){
            System.out.print(x+",");
        }
    }

    public static int[] prevSmaller(int[] a) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[a.length];
        
        for(int i=0;i<a.length;i++){
            if(st.isEmpty()){
                st.push(a[i]);
                res[i] = -1;
                continue;
            }
            
            while(!st.isEmpty() && st.peek() >= a[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                res[i] = st.peek();
            }else{
                res[i] = -1;
            }
            st.push(a[i]);
            
        }
        
        return res;
    }
}
