package leetCode;

import java.util.*;

public class LeetCode2492 {
    public static void main(String[] args) {
        int[][] roads = {{1,2,9},{2,3,6},{2,4,5},{1,4,7}};
                        System.out.println(minDist(roads, 4));
    }


    public static int minDist(int[][] roads,int n){
        
        Map<Integer,List<int[]>> map = new HashMap<>();
        int[] dist = new int[n+1];
        for(int[] road : roads){
            map.putIfAbsent(road[0],new ArrayList<>());            
            map.get(road[0]).add(new int[]{road[1],road[2]});
        }

        for(int i=1;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
        }

        Set<Integer> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        
       
        queue.add(new int[]{1,Integer.MAX_VALUE});
        while(!queue.isEmpty()){
            int[] v = queue.poll();
            set.add(v[0]);
            List<int[]> nodeVals = map.get(v[0]);
            if(nodeVals == null || nodeVals.size() <= 0){
                continue;
            }
            for(int[] nv : nodeVals){
                if(!set.contains(nv[0])){
                    int md = Math.min(dist[v[0]], Math.min(nv[1],dist[nv[0]]));
                    dist[nv[0]] = md;
                    queue.add(new int[] {nv[0],md});
                }
            }
        }
        
        return dist[n];
    }


}

class NodeVal {
    private int dist;
    private int dest;

    public NodeVal(int dest,int dist){
        this.dist = dist;
        this.dest = dest;
    }

    public void setDist(int dist){
        this.dist = dist;
    }

    public void setDest(int dest){
        this.dest = dest;
    }

    public int getDist(){
        return this.dist;
    }

    public int getDest(){
        return this.dest;
    }
}
