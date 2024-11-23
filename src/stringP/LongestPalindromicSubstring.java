package stringP;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
      // System.out.println(longestPalindromic("forgeeksskeegfor"));
       longestPalindromicSubstring("forgeeksskeegfor");
    }

    /**
     * Below approach will take O(N^3) time complexity
     * i.e O(N^2)* (O(N)+O(N))
     * 
     * since substring will also take the O(N) time complexity
     * @param str
     * @return
     */

    private  static  String longestPalindromic(String str){
        int maxLen = Integer.MIN_VALUE;
        String temp = "";
        for(int i = 0;i<str.length();i++){
            for(int j = i+1;j < str.length();j++){
                String str1 = str.substring(i, j+1);
                if(isPalindrom(str1, 0, str1.length()-1)){
                    if(maxLen < str1.length()){
                        maxLen = str1.length();
                        temp = str1;
                    }
                }
            }
        }

        return temp;
    }

    private static boolean isPalindrom(String str,int st,int end){
        if(st> end){
            return false;
        }

        if(st == end || st+1 == end){
            return true;
        }
        return str.charAt(st) == str.charAt(end) && isPalindrom(str, st +1, end-1);
    }

    /**
     * The below approach will take O(N)*(O(N)+O(N)) which is ~= O(N^2)
     */


     private static void longestPalindromicSubstring(String str){
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        for(int i=0;i<str.length();i++){
            int st = i;
            int end = i;
            int len = 0;
            while( st>= 0 && end < str.length() && str.charAt(st) == str.charAt(end)){
                len = end-st+1;
                if(maxLen < len){
                    start = st;
                    maxLen = len;
                }
                st--;end++;
            }

            st = i;
            end = i+1;

            while(st >=0 && end < str.length() && str.charAt(st) == str.charAt(end)){
                len = end-st+1;
                if(len > maxLen){
                    maxLen = len;
                    start = st;
                }
                st--;end++;
            }
        }

        System.out.println(str.substring(start , start+maxLen));

     }

}
