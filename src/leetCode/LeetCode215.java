package leetCode;

import java.util.PriorityQueue;

public class LeetCode215 {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        int[] a = new int[]{1,2,4,2,9,7,6,10};
        int k = 2;
        for(int i=0;i<a.length;i++){
            if(pq.size() >=k && pq.peek() < a[i]){
                pq.poll();
                pq.add(a[i]);
            }
            if(pq.size() < k){
                pq.add(a[i]);
            }
        }

        System.out.println(pq.poll());
    }
}
