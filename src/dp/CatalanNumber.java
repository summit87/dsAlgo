package dp;

public class CatalanNumber {
    public static void main(String[] args) {
        System.out.println(nthCatalanNumber(3));
        nthCatalanNumber1(3);
    }

    private static int nthCatalanNumber(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        if(n < 0){
            return 0;
        }

        int result = 0;
        for(int i=0;i<n;i++){
            result+=(nthCatalanNumber(i)*nthCatalanNumber(n-i-1));
        }

        return result;

    }

    private static void nthCatalanNumber1(int n){
        int[] dp = new int[n+1];
        dp[0] =dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = 0;
            for(int j=0;j<i;j++){
                dp[i]+=(dp[j]*dp[i-j-1]);
            }
        }

        System.out.println(dp[n]);
    }

}
