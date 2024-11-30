package leetCode;

public class LeetCode28 {
    public static void main(String[] args) {
        String str= "mississippi";
        System.out.println(isPatternFound(str, "issip"));
    }


    private static int[] lps(String str){
        int[] lps = new int[str.length()];
        int len = 1;
        int i=0;
        int j = 1;
        for(;i<str.length() && j < str.length();){
            if(str.charAt(i) == str.charAt(j)){
                len = i+1;
                lps[j] = len;
                i++;j++;
            }else{
                if(i >= 1){
                    i = lps[i-1];
                }else{
                    j++;
                }
            }
        }
        return lps;
    }


    private static int isPatternFound(String str,String pattern){
        int[] lps = lps(pattern);
        int i = 0;
        int j = 0;
        for(i = 0;i<str.length()&& j < pattern.length();i++){
            if(str.charAt(i) == pattern.charAt(j)){
                j++;
                if(j == pattern.length()){
                    System.out.println((i-j+1));
                    return i-j+1;
                }
            }else{
                if(j >= 1){
                    j = lps[j-1];
                }
            }
        }
        return -1;
    }
}
