package leetCode;

public class LeetCode5 {
    public static void main(String[] args) {
        String s = "asdracecaredf";
        System.out.println(longestPalindromic(s));
    }

    public static String getLongestSubString(String s){
        String res = "";
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length()-2;i++){
            for(int j = i+2;j < s.length();j++){
                int x=i;
                int k = j;
                if(isPalindrome(s, x, k) && maxLen < (j-i+1)){
                     maxLen = j-i+1;
                    res = s.substring(i, i+maxLen); 
                    System.out.println(maxLen);
                }
            }
        }
        return res;
    }

    public static boolean isPalindrome(String s,int st,int end){
        while(st <= end){
            if(s.charAt(st) == s.charAt(end)){
                st++;end--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static String longestPalindromic(String s){
        String res = "";
        int st = 0;
        int end = 0;
        int resSt = 0;
        int maxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            st = i;
            end = i;
            while(st >= 0 && end < s.length()&&s.charAt(st) == s.charAt(end)){
                if(maxLen < (end-st+1)){
                    maxLen = end-st+1;
                    resSt = st;
                }
                st--;
                end++;
            }

            st = i;
            end = i+1;
            while (st >= 0 && end < s.length() && s.charAt(end) == s.charAt(st)) {
                if(maxLen < (end-st+1)){
                    maxLen = end-st+1;
                    resSt = st;
                }
                st--;
                end++;
            }
        }
        return s.substring(resSt, resSt+maxLen);
    }
}
