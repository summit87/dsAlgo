package stringP;

public class KMPPatternMatchingAlgo {

    public static void main(String[] args) {
        String pat = "def";
        String str = "abcdefg";
        System.out.println(isPatternMatchin(str, pat) );
    }

    private static int[] patter(String str) {
        int[] pat = new int[str.length()];
        int j = 1;
        int len = 0;
        for (int i = 0; i < str.length() && j < str.length();) {
            if (str.charAt(i) == str.charAt(j)) {
                len = i + 1;
                pat[j] = len;
                j++;
                i++;
            } else {
                if (i >= 1) {
                    i = pat[i - 1];
                    len = i;
                } else {
                    j++;
                }
            }
        }
        return pat;
    }

    private static  boolean isPatternMatchin(String str,String pattern){
        int[] p = patter(pattern);
        int j=0;
        for(int i=0;i<str.length();i++){
            if(pattern.charAt(j) == str.charAt(i)){
                if(j == pattern.length()-1){
                    return true;
                }
                j++;
            }
            else{
                if(j >0 ){
                    j = p[j-1];
                }
            }
        }
        return false;
    }
}
