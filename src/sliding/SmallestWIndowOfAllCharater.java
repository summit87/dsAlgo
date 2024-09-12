package sliding;

import java.util.*;;

public class SmallestWIndowOfAllCharater {
    public static void main(String[] args) {
        // String s = "timetopractice";
        // String t = "toc";
        // System.out.println(smallestWindow(s, t));

        String s = "helloworld";
        String p = "low";
        // String s = "timetopractice";
        // String p = "toc";

        smallestWindowMap(s, p);
    }

    private static int smallestWindow(String s, String t) {
        int minWindow = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String s2 = s.substring(i, j);

                if (isAllCharacterExist(s2, t)) {
                    if (minWindow > (j - i)) {
                        minWindow = (j - i);
                    }
                }
            }
        }
        return minWindow;
    }

    private static boolean isAllCharacterExist(String s, String p) {

        int[] a = new int[26];
        for (int i = 0; i < p.length(); i++) {
            a[p.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i) - 'a'] > 0) {
                a[s.charAt(i) - 'a']--;
            }
        }

        for (int i = 0; i < p.length(); i++) {
            if (a[p.charAt(i) - 'a'] > 0) {
                return false;
            }
        }
        return true;
    }

    private static void smallestWindowMap(String s, String p) {
        Map<Character, Integer> pMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();
        int minLen = Integer.MAX_VALUE;
        int startIndex = 0;
        int start = 0;
        for (int i = 0; i < p.length(); i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i), 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);

            if (pMap.containsKey(s.charAt(i)) && pMap.get(s.charAt(i)) >= sMap.get(s.charAt(i))) {
                count++;
            }

            if (count == p.length()) {
                while (sMap.getOrDefault(s.charAt(start),0) > pMap.getOrDefault(s.charAt(start),0) || !pMap.containsKey(s.charAt(start))) {
                    if(pMap.getOrDefault(s.charAt(start),0) < sMap.getOrDefault(s.charAt(start),0)){
                        sMap.put(s.charAt(start), sMap.getOrDefault(start,0)-1);
                    }
                    start++;
                }
                if(minLen > (i-start+1)){
                    minLen = (i-start+1);
                    startIndex =start;
                }
            }
        }

        

        System.out.println(s.substring(startIndex, startIndex+minLen));

        
    }
}
