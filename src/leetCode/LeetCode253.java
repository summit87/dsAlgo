package leetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Given meeting room interval , find the minimum number of room to complete the all the meeting
 * Input: intervals = [[0,30],[5,10],[15,20]]
 */
public class LeetCode253 {
    public static void main(String[] args) {
        int[][] interval = {{9,10},{4,9},{4,17}};
        System.out.println(minRoom(interval));
    }

    public static int minRoom(int[][] interval){
        
        Arrays.sort(interval,(a,b) -> a[0] - b[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[1] - b[1]));
        for(int i=0;i<interval.length;i++){
            if(pq.isEmpty()){
                pq.offer(interval[i]);
                continue;
            }
            if(!pq.isEmpty() && pq.peek()[1] <= interval[i][0]){
                pq.poll();
            }
            pq.offer(interval[i]);
        }

        return pq.size();
    }
}
