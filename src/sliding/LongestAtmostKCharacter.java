package sliding;

import java.util.HashSet;
import java.util.Set;

public class LongestAtmostKCharacter {
    public static void main(String[] args) {
        String s = "abcddefg";
        int k=3;
        System.out.println(longestAtmostKCharacter1(s, k));
    }

    private static int longestAtmostKCharacter(String s,int k){
        int mxLen = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int ln = 1;
            for(int j=i+1;j<s.length();j++){
                if(set.size() == k && !set.contains(s.charAt(j))){
                    break;
                }
                set.add(s.charAt(j));
                ln++;
            }

            mxLen = Math.max(mxLen, ln);
        }
        return mxLen;
    }

    private static int longestAtmostKCharacter1(String s,int k){
        int mxLen = Integer.MIN_VALUE;
        int left=0;
        Set<Character> set = new HashSet<>();
        for(int i=0;i<s.length();){
            if(set.size() == k && !set.contains(s.charAt(i))){
                set.remove(s.charAt(left));
                left++;
            }else{
                set.add(s.charAt(i));
                mxLen = Math.max(mxLen, (i-left+1));
                i++;
            }
        }
        return mxLen;
    }


}
