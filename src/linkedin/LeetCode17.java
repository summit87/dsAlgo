package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode17 {
    public static void main(String[] args) {
         Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res= new ArrayList<>();
        letterCombination("23", 0, res, "", map);
        for(String l : res){
            System.out.println(l);
        }

    }

    public static void letterCombination(String str,int index,List<String> list,String res,Map<Character,String> map){
        if(index >= str.length()){
            list.add(res);
            return;
        }
        for(Character ch : map.get(str.charAt(index)).toCharArray()){
            res+=ch;
            letterCombination(str, index+1, list, res, map);
            res = res.substring(0,res.length()-1);
        }
    }
}
