package dp;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        longestPalindromic("forgeeksskeegfor");
    }


    /**
     * The idea of using DP to solve the problem
     * e.g : Geeks
     * We will using 2D table as boolean 
     * 1. We will first fill the table by assuming every single character is palindrome
     * 2. Then we will calcualte the palindromic substring for two character
     * if we take above example , 
     * 1 . G, e,e,k and s are single charecter and all are palindrome
     * 2.  if we take two character at a time , then Ge, ee, ek, and ks . among all these character , ee is only palindrom
     * 
     * now if we want to calculate the palindromic substring for more than 2 character ,
     * then , if first and last character are same and dp[first+1][last-1] is true 
     *          (why : e.g GEG are palindrom , if any only if next of first G and previous of last is palindrom)
     *  we need to follow above approch for the execution 
     */


     public static void longestPalindromic(String st){
        boolean[][] dp = new boolean[st.length()][st.length()];
        for(int i =0;i <st.length();i++){
            dp[i][i] = true; // this will make sure every single character is palindromic substring
        }

        int start = 0;
        int maxLen = 1;
        for(int i=0;i+1<st.length();i++){
            /**
             * Here we are comparing every two charecter and then figuring out if they are same , 
             * then this is palindromic substring with maxLen 2
             */
            if(st.charAt(i) == st.charAt(i+1)){
                dp[i][i+1] = true;
                maxLen = 2;
                start = i;
            }
        }

        /**
         * Now if will compare three or more character
         */

         for(int i = 3 ; i <=st.length();i++){
            for(int j=0;j<st.length()-i+1;j++){
                int k = j+i-1;
                if(dp[j+1][k-1] && st.charAt(j) == st.charAt(k)){
                    dp[j][k] = true;
                    if(maxLen < i){
                        maxLen = i;
                        start = j;
                    }
                }
            }
         }

         System.out.println(st.substring(start,maxLen+start));

     }

}
