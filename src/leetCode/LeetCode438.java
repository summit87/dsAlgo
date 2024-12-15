package leetCode;
import java.util.*;
/**
 * Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
 * @param args
 */
public class LeetCode438 {
    public static void main(String[] args) {
        String str="cbaebabacd";
        String pattern="abc";
        getAllIndex(str, pattern);
    }

    private static List<Integer> getAllIndex(String str,String pattern){
        List<Integer> list = new ArrayList<>();
        int k = pattern.length();
        Map<Character,Integer> patternMap = new HashMap<>();
        Map<Character,Integer> stringMap = new HashMap<>();
        for(int i= 0;i<pattern.length();i++){
            patternMap.put(pattern.charAt(i), patternMap.getOrDefault(pattern.charAt(i), 0)+1);
        }

        int left = 0;
        for(int i=0;i<str.length();i++){
            stringMap.put(str.charAt(i), stringMap.getOrDefault(str.charAt(i), 0)+1);
            if(i >= k){
                if(stringMap.containsKey(str.charAt(left))){
                    int x = stringMap.get(str.charAt(left))-1;
                    stringMap.put(str.charAt(left), x);
                    if(x == 0){
                        stringMap.remove(str.charAt(left));
                    }
                }
                left++;
            }

            if(stringMap.equals(patternMap)){
               list.add(left);
            }
        }
        return  list;
    }
}
