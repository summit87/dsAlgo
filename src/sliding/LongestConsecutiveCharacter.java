package array.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveCharacter {
    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstring1("tmmzuxt"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.length() <= 0) {
            return 0;
        }
        int maxLen = -1;
        int x = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) >= x) {
                x = map.get(s.charAt(i)) + 1;
                System.out.println(x + " : " + s.charAt(i));
            } else {
                maxLen = Math.max(maxLen, (i - x + 1));
            }
            map.put(s.charAt(i), i);

        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring1(String s) {
        int maxLen = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int i = 0; i < s.length();) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
                continue;
            }
            set.add(s.charAt(i));
            maxLen = Math.max(maxLen, (i - left + 1));
            i++;
        }
        return maxLen;
    }

}
