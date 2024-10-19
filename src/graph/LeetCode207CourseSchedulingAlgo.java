import java.util.*;

//[[0,10],[3,18],[5,5],[6,11],[11,14],[13,1],[15,1],[17,4]]
public class LeetCode207CourseSchedulingAlgo {
    public static void main(String[] args) {
        int[][] graph = { { 0, 10 }, { 3, 18 }, { 5, 5 }, { 6, 11 }, { 11, 14 }, { 13, 1 }, { 15, 1 }, { 17, 4 } };
        int v = 20;
        Queue<Integer> queue = new LinkedList<>();
        int[] indegre = new int[v];
        for(int i=0;i<graph.length;i++){
            indegre[graph[i][0]]++;
        }
        System.out.println(indegre);
        int total = 0;
        for(int i=0;i<graph.length;i++){
            if(indegre[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int v1 = queue.poll();
            total++;
            for(int i=0;i<graph.length;i++){
                if(graph[i][1] == v1){
                    indegre[graph[i][0]]--;
                    if (indegre[graph[i][0]] == 0) {
                        queue.add(graph[i][0]);
                    }
                }
                
            }
        }

        System.out.println(total);
        

    }
}
