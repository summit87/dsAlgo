package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode76 {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";

        System.out.println(minWindow(s, t));
    }

     public static String minWindow(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
        }
        int i = 0;
        int x = 0;
        int rem = t.length();
        String res = "";
        int minLen = Integer.MAX_VALUE;
        while (i < s.length()) {
            Character ch = s.charAt(i);
            if(map1.containsKey(ch) && map1.get(ch) >= 0){
                int c = map1.get(ch);
                c--;
                map1.put(ch, c);
                rem--;
            }

            while(x < i && rem == 0){
                if(minLen > (i-x+1)){
                    minLen = (i-x+1);
                    res = s.substring(x, i+1);
                }
                Character ch1 = s.charAt(x);
                if(map1.containsKey(ch1)){
                    rem++;
                    map1.put(ch1,map1.getOrDefault(ch1, 0)+1);
                }
                x++;
            }
    
            i++;
        }
        return res;
    }

}
