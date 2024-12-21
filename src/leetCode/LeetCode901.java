package leetCode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/online-stock-span/
 * we know 
 * The span of the stock's price in one day is the maximum number of consecutive days
 *  (starting from that day and going backward) for which the stock price was less than or 
 * equal to the price of that day.
 * 
 * If we carefully observed , a = {100,80,60,70,60}, if the stock price at index 2 is 60 , at 4 is 60, but before 60 there is no 
 * consecutive day where stock price is down ,  
 * 
 * Input
["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
[[], [100], [80], [60], [70], [60], [75], [85]]
Output
[null, 1, 1, 1, 2, 1, 4, 6]
 */
public class LeetCode901 {
    static Stack<int[]> stack = new Stack<>();
    public static void main(String[] args) {
        System.out.println(nextPrice(100)+","
        +nextPrice(80)+","
        +nextPrice(60)+","
        +nextPrice(70)+","
        +nextPrice(60)+","
        +nextPrice(75)+","
        +nextPrice(85));
    }

    public static int nextPrice(int nextPrice){
        int count = 1;
        if(stack.isEmpty() || stack.peek()[0] > nextPrice){
            int[] val = new int[2];
            val[0] = nextPrice;
            val[1] = count;
            stack.push(val);
            return count;
        }
        while(!stack.isEmpty() && stack.peek()[0] < nextPrice){
            count+=stack.pop()[1];
        }
        stack.push(new int[]{nextPrice,count});
        return count;
    }


}
