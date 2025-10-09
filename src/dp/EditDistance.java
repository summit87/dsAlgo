package dp;

public class EditDistance {
    public static void main(String[] args) {
        String s1="abcd";
        String s2="bcfe";
        System.out.println(minDist(s1, s2, s1.length(), s2.length()));
    }

    private static int minDist(String s1,String s2,int len1,int len2){

        if(len1  <=0){
            return len2;
        }
        if(len2 <= 0){
            return len1;
        }

        if( s1.charAt(len1-1) == s2.charAt(len2-1)){
            return minDist(s1, s2, len1-1, len2-1);
        }
        return 1+Math.min(minDist(s1, s2, len1-1, len2),Math.min(minDist(s1, s2, len1, len2-1), minDist(s1, s2, len1-1, len2-1)));
    }
}
