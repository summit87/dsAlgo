package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Cheapest Flights Within K Stops
 */
public class LeetCode787 {
    public static void main(String[] args) {
        
    } 

    public static  int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer,List<Node>> map = new HashMap<>();
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int[] flight : flights){
            Node n3 = new Node();
            n3.nodeVal = flight[1];
            n3.cost = flight[2]; 
            map.putIfAbsent(flight[0],new ArrayList<>());
            map.get(flight[0]).add(n3);
        }

        Queue<Node> queue = new LinkedList<>();
        Comparator<Node> c = Comparator.comparingInt(a -> a.cost);
        PriorityQueue<Node> pq = new PriorityQueue<>(c);
        Node source = new Node();
        source.nodeVal = src;
        source.cost = 0;
        source.count = k+1;
        pq.offer(source);
        while(!pq.isEmpty()){
            Node n1 = pq.poll();
            int k1 = n1.count;
            if(n1.cost > dist[n1.nodeVal]){
                continue;
            }

            if(!map.containsKey(n1.nodeVal)){
                continue;
            }

            if(k1 == 0 && n1.nodeVal == dst){
                dist[n1.nodeVal] = Math.min(dist[n1.nodeVal], n1.cost);
            }

            for(Node n2 : map.get(n1.nodeVal)){
                 int newCost = dist[n2.nodeVal] + n1.cost;
                 if(dist[n2.nodeVal] > newCost){
                    dist[n2.nodeVal] = newCost;
                    n2.cost = newCost;
                    n2.count = k-1;
                    pq.offer(n2);
                 }
            }
        }

        return dist[dst];
    }
}

class Node{
    int nodeVal;
    int cost;
    int count;
}
