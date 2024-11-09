package stack;
import java.util.*;
/**
 * Input :  Prefix :  *+AB-CD
Output : Infix : ((A+B)*(C-D))

Input :  Prefix :  *-A/BC-/AKL
Output : Infix : ((A-(B/C))*((A/K)-L))
 */
/**
 * 
 */
public class PrefixToInfix {
    public static void main(String[] args) {
        String input = "*-A/BC-/AKL";
        Stack<String> stack = new Stack<>();
        for(int i=input.length() - 1;i >= 0;i--){
            char ch = input.charAt(i);
            if(!isOperand(ch)){
                stack.push(String.valueOf(ch));
                continue;
            }
            if(!stack.isEmpty() && stack.size() >=2){
                String op1 = stack.pop();
                String op2 = stack.pop();
                String res = "("+op1+ch+op2+")";
                stack.push(res);
            }
        }

        System.out.println(stack.pop());
    }

    private static boolean isOperand(char ch){
        return (ch == '+' || ch=='*' || ch=='/' || ch =='-');
    }
}
