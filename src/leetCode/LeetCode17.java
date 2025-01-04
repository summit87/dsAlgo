package leetCode;

import java.util.*;

public class LeetCode17 {
    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        String str= "234";
        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        phone(str, "", result, 0, map);
        System.out.println(result);
    }


    public static void phone(String str,String res,List<String> result,int index,Map<Character,String> map){
        if(index >= str.length()){
            result.add(res);
            return;
        }

        char[] ch= map.get(str.charAt(index)).toCharArray();
        for(char c : ch){
            res+=String.valueOf(c);
            phone(str, res, result, index+1, map);
            res = res.substring(0, res.length()-1);
        }
    }
}
