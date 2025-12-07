package leetCode;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode632 {

    /**
     * Smallest range covering all the elemnet
     *
     * Input: nums = [[4,10,15,24,26],[0,9,12,20],[5,18,22,30]] Output: [20,24]
     *
     * 
     * *[4,10,15,24,26], [0,9,12,20], [5,18,22,30] Since we need find the min and
     * max which should have min difference and at least one elemnet can be
     * included
     * 
     * *let say i am taking first element from each array 4,0,5 => min. 0, max =
     * 5 => diff = 5 , now let's take another element form first array 10,0,5 =>
     * min = 0, max = 10 => diff => 10 , so we can't move further in next
     * element , now let's move next element in 2nd array 4,5,9 =>min = 4,max =
     * 9 => diff => 5
     * 
     * *considering above run, it seems we should choose and move to next element
     * from the array which have minimum element among those array
     *
     *
     */

    public static void main(String[] args) {
        List<List<Integer>> arrays = Arrays.asList(Arrays.asList(4, 10, 15, 24, 26), Arrays.asList(0, 9, 12, 20),
                Arrays.asList(5, 18, 22, 30));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        // pq will contains the data = {value,row,col};
        int max = Integer.MIN_VALUE;
        for(int i = 0;i < arrays.size();i++){
            pq.add(new int[]{arrays.get(i).get(0),i,0});
            max = Math.max(max, arrays.get(i).get(0));
        }

        int min = 0;
        int start = 0 ; int end = 100000;

        while(pq.size() == arrays.size()){
            int[] pqVal = pq.poll();
            min = pqVal[0];
            int r = pqVal[1];
            int col = pqVal[2];
            if(max - min < end - start){
                end = max;
                start = min;
            }

            if(col+1 < arrays.get(r).size()){
                int nextVal = arrays.get(r).get(col+1);
                pq.add(new int[] {nextVal,r,col+1});
                max = Math.max(max, nextVal);
            }
        }

        System.out.println(start+ " : "+ end );
        


    }
}
