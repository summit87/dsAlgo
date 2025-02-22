package leetCode;
import java.util.*;

public class LeetCode1514 {
    public static void main(String[] args) {
        int[][] edges  = {{0,1},{1,2},{0,2}};
        double[] prob = {0.5,0.5,0.2};
        // int s = 0;
        // int dest = 2;
        // int n= 3;
        // System.out.println(max(edges, prob, s, dest, n));
// timeTaken = change * (timeTaken / change + 1) + time;
        System.out.println((3+5*(9%(5+1))));
    }

    public static double max(int[][] edges,double[] prob,int s,int e,int ver){
        Map<Integer,List<NodeVal>> map = new HashMap<>();
        for(int i =0;i<edges.length;i++){
            map.putIfAbsent(edges[i][0], new ArrayList<>());
            map.putIfAbsent(edges[i][1], new ArrayList<>());
            NodeVal nodeVal = new NodeVal();
            nodeVal.dest = edges[i][1];
            nodeVal.prob = prob[i];
            map.get(edges[i][0]).add(nodeVal);
            nodeVal = new NodeVal();
            nodeVal.dest = edges[i][0];
            nodeVal.prob = prob[i];
            map.get(edges[i][1]).add(nodeVal);
        }

        double[] dest = new double[ver];
       

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        dest[s] = 1.0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<NodeVal> nodeVals = map.get(v);
            if(nodeVals == null || nodeVals.size() <= 0){
                continue;
            }
            for(NodeVal nv:nodeVals){
                if(nv.prob*dest[v] > dest[nv.dest]){
                    dest[nv.dest] = nv.prob*dest[v];
                    queue.add(nv.dest);
                }
            }
        }

        return dest[e];
    }
}

class NodeVal{
    int dest;
    double prob;
}
