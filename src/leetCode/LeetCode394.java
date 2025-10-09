package leetCode;

import java.util.Stack;

public class LeetCode394 {
    public static void main(String[] args) {

        String s = "300[ab2[c5[s]]]1[zx]";


        Stack<String> st = new Stack<>();
        String res = "";
        for(int index = s.length()-1;index>=0;index--){
            if(isValidChar(s.charAt(index))){
                st.push(String.valueOf(s.charAt(index)));
                continue;
            }

            String temp="";
            while(!st.isEmpty()) {
                String s1 = st.pop();
                if(s1.equals("]")){
                    break;
                }
                temp+=s1;
            }
            index --;
            String num = "";
            int i1 = 0;

            while(index >= 0){
                if(!((s.charAt(index)-0) >=48 && (s.charAt(index)-0)<=57)){
                    break;
                }
               i1++;
                index--;
            }
            index++;
            int val = Integer.parseInt(String.valueOf(s.substring(index, index+i1)));
           System.out.println(val);
            StringBuilder temp1 = new StringBuilder();
            for(int i=0;i<val;i++){
                temp1.append(temp);
            }
            st.push(temp1.toString());
        }

        while(!st.isEmpty()){
            res+=st.pop();
        }
        System.out.println(res);
    }

    public static boolean isValidChar(char ch){
        return (ch >= 'a' && ch <= 'z') || ch==']';
    }
}
