package leetCode;

import java.util.Arrays;

/**
 * Buy and sell stock at most two times
 * 
 * 1. first approach we can buy and sell in each segement and take maximum of
 * these
 * 2. second approach,
 * consider i am buying stock on day first and selling on day 3rd and when i am
 * going to buy the stock on day 4th , then
 * and selling on day 6th, then total profit we wil calculating as mentioned
 * below
 * profit on day 3rd = (sell cost on day 3rd - buy cost on day 1st)
 * profit on day 6th will be, i.e net profit : (sell cost on day 6th - (profit
 * on day 1st - buy cost on day 4th)) ,
 * we will use 2nd approach which give timecompalexity O(n) and space complexity
 * O(1)
 */
public class LeetCode123 {
    public static void main(String[] args) {
        int[] a = { 3, 3, 5, 0, 0, 3, 1, 4 };
        //int[] a = {1,2,3,4,5};
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            profit = Math.max(profit, (getProfitInGivenRane(a,0,i)
                    + getProfitInGivenRane(a, i+1, a.length)));
        }
        System.out.println(getMin1(a,2));

    }

    // approach first

    public static int getProfitInGivenRane(int[] a,int left,int right) {
        if(a.length == 0){
            return 0;
        }
        int profit = 0;
        int min = a[0];
        if(left >= a.length){
            return 0;
        }

        if(right >= a.length){
            return 0;
        }
        if(left >= right){
            return 0;
        }
        for (int i = left; i <= right; i++) {
            if (profit < (a[i] - min) ) {
                profit = (a[i] - min);
            } else if (a[i] < min) {
                min = a[i];
            }
        }
        return profit;
    }
//int[] a = { 3, 3, 5, 0, 0, 3, 1, 4 };
    public static int getMin(int[] a){
        int profit= 0;
        int profit1= 0;
        int buy1 = a[0];
        int buy2 = a[0];

        for(int i=1;i<a.length;i++){
            buy1 = Math.min(buy1, a[i]);
            profit1 = Math.max(profit1, (a[i] - buy1));
            buy2 = Math.min(buy2, (a[i]-profit1));
            profit = Math.max(profit, (a[i]-buy2));
        }
        return profit;
    }

    public static int getMin1(int[] a,int x){
        int[] profit = new int[x+1];
        int[] buy = new int [x+1];
        Arrays.fill(buy, Integer.MAX_VALUE);
        for(int i=0;i<a.length;i++){
            for(int k=0;k<x;k++){
                buy[k+1] = Math.min(buy[k+1], a[i] - profit[k]);
                profit[k+1] = Math.max(profit[k+1], a[i]-buy[k+1]);
            }
        }

        return profit[x];
    }
}
