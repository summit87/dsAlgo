package sliding.reIteration;

import java.util.*;

public class MaxInSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] a = { 9,10,9,-7,-4,-8,2,-6 };
        for(Integer num : getMax(a, 5)){
            System.out.print(num+",");
        }
    }

    private static int[] getMax(int[] nums,int k){
       
        int[] result = new int[nums.length-k+1];
        int max = Integer.MIN_VALUE;
        int index = 0;
        int x = 0;
        Deque<Integer> deque = new LinkedList<>();
        for(int i=0;i<k;i++){
           while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
            deque.removeLast();
           }
           deque.addFirst(i);
        }
        
       result[x++] = nums[deque.peekLast()];
        for(int i = k; i < nums.length;i++){
            while(!deque.isEmpty() && i - deque.peekFirst() >= k){
                deque.removeFirst();
            }

            while(!deque.isEmpty() && nums[deque.getLast()] < nums[i] ){
                deque.removeLast();
            }

            deque.addFirst(i);
            result[x++] = nums[deque.getLast()];
        }
        return result;
    }

    
}