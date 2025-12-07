package javaP;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class UsePQInMap {
    public static void main(String[] args) {
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((m1,m2) -> m2.getKey() - m1.getKey());
        Map<Integer,Integer> m3 = new HashMap<>();
        m3.put(20, 10);
        m3.put(5, 10);
        m3.put(11, 10);
        m3.put(3, 10);
        m3.put(28, 10);
        for(Map.Entry<Integer,Integer> m4 : m3.entrySet()){
            pq.add(m4);
        }

        System.out.println(pq.poll().getKey());
    }
}
