package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class BridgeInGraph {

    static int time=0;
    public static void main(String[] args) throws FileNotFoundException {
        bridgeInGraph("bridge.txt");
    }


    public static void bridgeInGraph(String fileName) throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(fileName));
        Map<Integer,List<Integer>> map = new HashMap<>();
        int v = scanner.nextInt();
        while(scanner.hasNext()){
            String[] s = scanner.next().split(",");
            Integer src = Integer.parseInt(s[0]);
            Integer dest = Integer.parseInt(s[1]);
            map.putIfAbsent(src, new ArrayList<>());
            map.putIfAbsent(dest, new ArrayList<>());
            map.get(src).add(dest);
            map.get(dest).add(src);
        }

        int[] low = new int[v];
        int[] desc = new int[v];
        int[] parent = new int[v];
       Set<Integer> set = new HashSet<>();
       List<String> bridgeNode = new ArrayList<>();
       for(int i=0;i<v;i++){
        if(!set.contains(i)){
            findBridge(map,bridgeNode,low,desc,set,i,parent);
        }
       }

       for(String s : bridgeNode){
        System.out.println(s);
       }
    }


    private static void findBridge(Map<Integer,List<Integer>> grpah,List<String> list,int[] low,int[] desc,Set<Integer> set,int vertex,int[] parent){
        set.add(vertex);
        low[vertex] = time;
        desc[vertex] = time;
        time = time+1;
        List<Integer> nodes = grpah.getOrDefault(vertex,null);
        if (nodes == null ) {
            return;
        }
        for(Integer node : nodes){
            if (!set.contains(node)) {
                parent[node] = vertex;
                findBridge(grpah, list, low, desc, set,node,parent);
                low[vertex] = Math.min(low[vertex],low[node]);
                if(low[node] > desc[vertex]){
                    list.add((vertex+" - "+node));
                }
            }else if(parent[vertex] != node){
                low[vertex] = Math.min(low[vertex], desc[node]);
            }
        }
    }



}
