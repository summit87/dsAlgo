package sliding;

import java.util.*;


/**
 * Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.
 */
public class LongestSubstringAtLeastTwoUniqueCharacter {

    public static void main(String[] args) {
       System.out.println(longestLength("eceba"));
    }

    private static int longestLength(String s){
        int maxLen = Integer.MIN_VALUE;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        while(right < s.length()){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            
           while(map.size()== 3){
                int val =map.get(s.charAt(left))-1;
               map.put(s.charAt(left),val);
               if(map.get(s.charAt(left)) == 0){
                    map.remove(s.charAt(left));
                }
                left = left+1;
            }
            maxLen = Math.max(maxLen,(right-left+1));
           right++;
            
        }
        
        
        return maxLen;
    }

}
