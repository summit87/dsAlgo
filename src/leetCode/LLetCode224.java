package leetCode;

import java.util.*;

public class LLetCode224 {
    public static void main(String[] args) {
        StringBuilder db = new StringBuilder("(1+(4+5+2)-3)+(6+890)");
        System.out.println(calculate("1-(     -2)"));
    }

    public static int calculate(String s) {
        Stack<Object> st = new Stack<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            Character ch = s.charAt(i);
            if (ch == ' ') {
                continue;
            }
            if (ch == ')') {
                st.push(ch);
                continue;
            }

            int j = i;
            int x = i;
            int n = 0;
            int currentNum = 0;
            while (j >= 0 && isOperand(s.charAt(j))) {
                currentNum = currentNum + (int) Math.pow(10, n)*(s.charAt(j)-'0');
                n++;
                j--;
                x = j + 1;
            }
            i = x;
            if (currentNum > 0) {
                st.push(currentNum);
            } else {
                if(ch == '+' || ch == '-'){
                    st.push(ch);
                }
                else if (ch == '(') {
                    int res = eval(st);
                    st.pop();
                    st.push(res);
                }
            }
        }
        return eval(st);
    }

     public static int eval(Stack<Object> st) {
        if (st.isEmpty()) {
            return 0;
        }
        int res = 0;
        if(st.isEmpty() || ((Character)st.peek() == ')' || (Character)st.peek() == '-' || (Character)st.peek() == '+')){
            st.pop();
            //st.push(0);
        }else{
            res = (int) st.pop();
        }
       
        System.out.println(res);
        while (!st.isEmpty() && (char)st.peek() !=')') {
            Character ch = (Character) st.pop();
            if (ch == '+') {
                res += (int) st.pop();
            }
            if (ch == '-') {
                res -= (int) st.pop();
            }
        }
        //st.pop();
        return res;
    }

    public static boolean isOperand(Character ch) {
        return (ch >= '0' && ch <= '9');
    }
}