package leetCode;

import java.util.*;

/**
 * https://leetcode.com/problems/generate-parentheses/description/?envType=problem-list-v2&envId=backtracking
 * 
 * The idea behind to generate the valid parenthesis , definately , if the value of the number is 3 , then valid parenthesis length is 2*n (considering open and close brackets)
 * e.g : if n=1 , then valid parenthesis is "()" , which is length of 2 , i.e N*2
 * considering above info , we can take two type of index ,
 * one is left index and other is right index
 * if left index more than the given length (i.e n) , then we are done to add open bracket "(". then if left index is more than the right index , the we will start adding close
 * brackt (")") , if result string length is equal to 2*n and resultant string is valid pair then add into result list.
 * 
 * 
 * 
 */
public class LeetCode22 {
    public static void main(String[] args) {
        List<String> res = new ArrayList<>();
        resultantValidParenthesis("", res, 0, 0, 2);
        System.out.println(res);
    }

    public static void resultantValidParenthesis(String res,List<String> result,int leftIndex,int rightIndex,int n){
        if(res.length() == 2*n && isValid(res)){
            result.add(res);
            return;
        }

        if(leftIndex < n){
            resultantValidParenthesis(res+"(", result, leftIndex+1, rightIndex, n);
            
        }
        if(leftIndex > rightIndex){
            resultantValidParenthesis(res+")", result, leftIndex, rightIndex+1, n);
        }

    }

    public static boolean isValid(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '('){
                count++;
                continue;
            }
            count--;
        }
        if(count != 0){
            return false;
        }
        return true;
    }
}
