package stringP;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
       System.out.println(longestPalindromic("forgeeksskeegfor"));
    }

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
}
