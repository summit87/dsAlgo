package sliding;

import java.util.*;

public class LongestUniqueCharacter {
    public static void main(String[] args) {
        String str = "nfpdmpi";
        System.out.println(longestUnique(str));
    }

    private static int longestUnique(String str){
        if(str.length() <= 1){
            return str.length();
        }

        int maxLen= Integer.MIN_VALUE;
        int maxLen1 = Integer.MIN_VALUE;
        int left= 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        while(right < str.length()){
            if(!set.contains(str.charAt(right))){
                set.add(str.charAt(right));
                maxLen = set.size();
                right++;
                continue;
            }
           
            while(left < right && set.contains(str.charAt(right))){
                set.remove(str.charAt(left));
                left++;
                if(maxLen1 < (right-left+1)){
                    maxLen1 = right - left + 1;
                }
            }
            set.add(str.charAt(right));
            right++;
        }

        return  Math.max(maxLen, maxLen1);

    }
}
