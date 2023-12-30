package stringP;

public class LongestCommonPrefix {
    public static void main(String[] args){
        String[] strs = {"flower","flow","flight"};
        String longestCommonPrefix = strs[0];
        int i=1;
        while (i < strs.length){
            while (strs[i].indexOf(longestCommonPrefix) != 0){
                longestCommonPrefix = longestCommonPrefix.substring(0,longestCommonPrefix.length()-1);
            }
            i++;
        }
    System.out.println(longestCommonPrefix);
    }
}
