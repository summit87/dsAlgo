package leetCode;

public class LeetCode516 {
    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(longestPalindromicSubSequence(str));
    }

    public static int longestPalindromicSubSequence(String str){
        int[][] dp = new int[str.length()][str.length()];
        for(int i=0;i<str.length()-1;i++){
            dp[i][i] = 1;
            if(str.charAt(i) == str.charAt(i+1)){
                dp[i][i+1] = 2;
            }
        }
        dp[str.length()-1][str.length()-1] = 1;
        for(int i=1;i<str.length();i++){
            for(int j=i+1;j<str.length();j++){
                if(str.charAt(i) == str.charAt(j)){
                    dp[i][j] = 2+dp[i-1][j]; 
                }else{
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        for(int i=0;i<str.length();i++){
            for(int j=0;j<str.length();j++){
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }

        return dp[str.length()-2][str.length()-1];
    }
}
