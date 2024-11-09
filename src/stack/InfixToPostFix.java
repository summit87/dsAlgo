package stack;

import java.util.*;

/**
 * Input: A + B * C + D
 * Output: ABC*+D+
 * 
 * 
 * Input: ((A + B) – C * (D / E)) + F
 * Output: AB+CDE/*-F+
 */
/**
 * res1 = ABC*+D+
 * res2 = AB+CDE/*-F+
 * st : (
 */
public class InfixToPostFix {
    public static void main(String[] args) {
        String input = "((A + B) - C * (D / E)) + F";
        String exp = "";
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < input.length(); i++) {
           
        }
        System.out.println(exp);
    }

    private static boolean isOperand(char ch) {
        return (ch >= 'A' && ch <= 'Z');
    }

    private static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
}
