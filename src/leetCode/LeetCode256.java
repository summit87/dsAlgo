package leetCode;

public class LeetCode256 {
    public static void main(String[] args) {
        int[][] cost =  {{17,2,17},{16,16,5},{14,3,19}};
        System.out.println(minCost(cost));
    }

     public static int minCost(int[][] cost) {
        int minCost = Integer.MAX_VALUE;
        int[][] paintCost = new int[cost.length][cost[0].length];
        for(int i=0;i<cost[0].length;i++){
            paintCost[0][i] = cost[0][i];
        }


        for(int i=1;i<cost.length;i++){
            for(int j=0;j<cost[i].length;j++){
                minCost = Integer.MAX_VALUE;
                for(int k=0;k<cost[i].length;k++){
                    if(k !=j && minCost > paintCost[i-1][k]){
                        minCost = paintCost[i-1][k];
                    }
                }
                paintCost[i][j] = cost[i][j]+minCost;
            }
        }

        for(int i=0;i<cost.length;i++){
            for(int j=0;j<cost[i].length;j++){
                System.out.print(paintCost[i][j]+",");
            }
            System.out.println();
        }

        System.out.println("*******************");

        minCost = Integer.MAX_VALUE;
        for(int i=0;i<cost[0].length;i++){
            minCost = Math.min(paintCost[cost.length-1][i],minCost);
        }


       return minCost;
    }


}
