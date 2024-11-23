package dp;

public class LIS1 {

    static int maxLen  = Integer.MIN_VALUE;
    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        lis(a, a.length-1);
        System.out.println(maxLen);
    }

    private static int lis(int[] a,int len){
        int res = 1;
        int maxTillLen  =1;



        for(int i = 0;i<len;i++){
            res = lis(a, i);
            if(1+res >= maxTillLen && a[i] < a[len]){
                maxTillLen = 1+res;
            }
        }

        if(maxTillLen > maxLen){
            maxLen = maxTillLen;
        }

        return maxTillLen;
    }


}
