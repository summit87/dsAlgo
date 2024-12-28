package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * visited[ ] = to keep track of the visited vertices to implement DFS
disc[ ] = to keep track when for the first time that particular vertex is reached
low[ ] = to keep track of the lowest possible time by which we can reach that vertex 
‘other than parent’ so that if edge from parent is removed can the particular node can be reached other than parent.
 */
public class ArticulationPoint {

    static int time=0;
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(findArticulationPoint("ap1.txt"));
    }

    public static List<Integer> findArticulationPoint(String fileName) throws FileNotFoundException{
        List<Integer> list = new ArrayList<>();
        int vertex = 0;
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        Scanner sc = new Scanner(new File(fileName));
        vertex = sc.nextInt();
        int[] parent= new int[vertex];
        int[] low = new int[vertex];
        int[] disc = new int[vertex];
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            int src = Integer.parseInt(s[0]);
            int dest = Integer.parseInt(s[1]);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        findArticulationPoint(graph, visited, low, disc, 0, parent,list);
        for(int i=0;i<vertex;i++){
            System.out.println(i+" -> "+low[i]+" : "+disc[i]);
        }
        
        return list;
    }


    static void findArticulationPoint(Map<Integer,List<Integer>> graph,Set<Integer> set,int[] low,int[] desc,int vertex,int[] parent,List<Integer> ap){
        low[vertex] = time;
        desc[vertex] = time;
        time++;
        set.add(vertex);
        List<Integer> list = graph.get(vertex);
        if (list == null) {
            return;
        }
        for(Integer v : list){ 
            if(!set.contains(v)){
                parent[v] = vertex;
                findArticulationPoint(graph, set, low, desc, v, parent,ap);

                low[vertex] = Math.min(low[vertex], low[v]);
                if(low[v] > desc[vertex]){
                    ap.add(vertex);
                }
            }else if(parent[vertex] != v){
                low[vertex] = Math.min(low[vertex], desc[v]);
            }

        }
    }




}
