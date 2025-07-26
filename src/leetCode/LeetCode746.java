package leetCode;

public class LeetCode746 {
    public static void main(String[] args) {
        int[] cost={1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCost(cost, 1));
    }

    public static int minCost(int[] cost,int steps){
        if(steps >= cost.length){
            return 0;
        }
        return cost[steps]+Math.min(minCost(cost, steps+1),minCost(cost, steps+2));
    }
}
