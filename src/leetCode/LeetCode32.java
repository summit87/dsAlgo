package leetCode;

public class LeetCode32 {
    public static void main(String[] args) {
        System.out.println(longestLength("(((())(()()()"));
    }

    public static int longestLength(String s){
        int maxLen = Integer.MIN_VALUE;
        int left = 0;
        int right = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i) == ')'){
                right++;
            }

            if(left == right){
                maxLen = Math.max(maxLen, 2*right);
            }

            if(right > left){
                left = 0; right = 0;
            }
        }
        left = 0;right=0;
         for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i) == '('){
                left++;
            }else if(s.charAt(i) == ')'){
                right++;
            }

            if(left == right){
                maxLen = Math.max(maxLen, 2*left);
            }

            if(right < left){
                left = 0; right = 0;
            }
        }
        return maxLen;
    }
}
