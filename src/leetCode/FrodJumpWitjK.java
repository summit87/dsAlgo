package leetCode;

public class FrodJumpWitjK {
    public static void main(String[] args) {
        int[] a = {30,10,60,10,60,50};
        System.out.println(minJump(a,  5));
    }

    public static int minJump(int[] a,int len,int k){
        if(len < 0){
            return 0;
        }

        int minJum = Integer.MAX_VALUE;
        for(int i = 1;i<=k && len-i >= 0;i++){
            minJum = Math.min(minJum,minJump(a, len-i, k)+ Math.abs(a[len] - a[len-i]));
        }

        return minJum;
    }


    public static int minJump(int[] a,int k){
        int[] dp = new int[a.length+1];

        for(int i=a.length-2;i >= 0;i--){
            int min = Integer.MAX_VALUE;
            for(int x=1;x <=k ;x++){
                if(i+x < a.length){
                    min = Math.min(min, dp[i+x]+Math.abs(a[i] - a[i+x]));
                }
            }
            dp[i] = min;
        }

        return dp[0];
    }
}
