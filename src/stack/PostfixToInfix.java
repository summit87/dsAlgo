package stack;

import java.util.Stack;

/**
 * Input : abc++
 * Output : (a + (b + c))
 * 
 * Input : ab*c+
 * Output : ((a*b)+c)
 */

/*
 * 1. Scan the input from left to right
 * 2. check if the character is operand , then add to stack
 * 3. if we find first operator , pull two character form the stack , create
 * expresion and push back to stack
 * 4. continue 2 and 3rd until all the charecter are not scaned
 * 
 * Note : here the priority of the operator does't matter
 */
public class PostfixToInfix {
    public static void main(String[] args) {

        int operatorCount = 0;
        int operandCount = 0;
        Stack<String> stack = new Stack<>();
        String input = "abc-+";
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (!isOperator(ch)) {
                operandCount++;
                stack.push(String.valueOf(ch));
                continue;
            }
            operatorCount++;
            if (!stack.isEmpty() && stack.size() >= 2) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infix = "(" + operand2 + ch + operand1 + ")";
                stack.push(infix);
            }
        }
        if (operatorCount < operandCount) {
            System.out.println(stack.pop());
        }else{
            System.out.println("Invalid expression");
        }

    }

    private static boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '/' || ch == '*');
    }
}
