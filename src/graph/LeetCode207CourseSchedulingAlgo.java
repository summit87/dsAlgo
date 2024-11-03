package graph;
import java.util.*;

//[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
public class LeetCode207CourseSchedulingAlgo {
    public static void main(String[] args) {
        int[][] graph = { { 0, 10 }, { 3, 18 },  { 6, 11 }, { 11, 14 }, { 13, 1 }, { 15, 1 }, { 17, 4 } };
        int v = 20;
        Queue<Integer> queue = new LinkedList<>();
        
        Map<Integer, Integer> indegre = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        for(int i =0;i<v;i++){
            indegre.put(i, 0);
        }
        for (int i = 0; i < graph.length; i++) {
            int ind = 1;
            if (indegre.containsKey(graph[i][1])) {
                ind = indegre.get(graph[i][1]) + 1;
            }
            indegre.put(graph[i][1], ind);
        }
        int total = 0;
        for (int i = 0; i < v; i++) {
            if (indegre.containsKey(i) && indegre.get(i) == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int v1 = queue.poll();
            if (indegre.containsKey(v1) && indegre.get(v1) == 0) {
                order.add(v1);
            }
            total++;
            for (int i = 0; i < graph.length; i++) {
                if (graph[i][0] == v1) {
                    int ind = indegre.get(graph[i][1]) - 1;
                    indegre.put(graph[i][1],ind);
                    if (ind == 0) {
                        queue.add(graph[i][1]);
                    }
                }

            }
        }
        
        System.out.println(order);
        System.out.println(total);

    }
}
