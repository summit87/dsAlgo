package dp;

/**
 * N = 3, W = 4, profit[] = {1, 2, 3}, weight[] = {4, 5, 1}
 */
public class ZeroOneKnapsack {
    public static void main(String[] args) {
        int[] p = {10,15,40};
        int[] w = {1,2,3};
        int len = 3;
        int weight = 6;
        // System.out.println(getMaxProfit(w, p, len, weight));

        System.out.println(getMaxProfitDP(w, p, weight));
    }

    public static int getMaxProfit(int[] w,int[] p,int len,int weight){
        if(len <= 0 || weight == 0){
            return 0;
        }

        if(weight < w[len-1]){
            return getMaxProfit(w,p,len-1,weight);
        }

        return Math.max(getMaxProfit(w, p, len-1, weight), p[len-1]+getMaxProfit(w, p, len-1, weight-w[len-1]));
    }

    public static int getMaxProfitDP(int[] weight,int[] profit,int w){
        int[][] arr = new int[weight.length+1][w+1];

        for(int i=0;i<=weight.length;i++){
            arr[i][0] = 0;
        }

        for(int j=0;j<=w;j++){
            arr[0][j] = 0;
        }

        for(int i=1;i<=weight.length;i++){
            for(int j=1;j<=w;j++){
                if(j >= weight[i-1]){
                    arr[i][j] = Math.max(arr[i-1][j], profit[i-1]+arr[i-1][j-weight[i-1]]);
                }else{
                    arr[i][j] = arr[i-1][j];
                }
            }
        }

        for(int i=0;i<=weight.length;i++){
            for(int j=0;j<=w;j++){
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }

        return arr[weight.length][w];
    }

}
