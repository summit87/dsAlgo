import java.util.*;

//[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
public class LeetCode207CourseSchedulingAlgo {
    public static void main(String[] args) {
        int[][] graph = { { 0, 10 }, { 3, 18 },  { 6, 11 }, { 11, 14 }, { 13, 1 }, { 15, 1 }, { 17, 4 } };
        int v = 20;
        Queue<Integer> queue = new LinkedList<>();
        int[] indegre = new int[v];
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> order = new ArrayList<>();
        for(int i =0;i<v;i++){
            map.put(i, 0);
        }
        for (int i = 0; i < graph.length; i++) {
            int ind = 1;
            if (map.containsKey(graph[i][1])) {
                ind = map.get(graph[i][1]) + 1;
            }
            map.put(graph[i][1], ind);
        }
        int total = 0;
        for (int i = 0; i < v; i++) {
            if (map.containsKey(i) && map.get(i) == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int v1 = queue.poll();
            if (map.containsKey(v1) && map.get(v1) == 0) {
                order.add(v1);
            }
            total++;
            for (int i = 0; i < graph.length; i++) {
                if (graph[i][0] == v1) {
                    int ind = map.get(graph[i][1]) - 1;
                    map.put(graph[i][1],ind);
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
