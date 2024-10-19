import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import dp.LIS;
public class EdgeColoring {
    public static void main(String[] args) throws FileNotFoundException {
        Graph8 graph8 = new Graph8("edge.txt");
        System.out.println(graph8.isColorable(1));
        System.out.println(graph8.getColor());
    }
}


class Graph8{
    Map<Integer,List<Edge>> map;
    Set<Edge> isEdgeVisited;;
    Set<Integer> isNodevisited;
    Set<Integer> colorSet;
    public Graph8(String fileName) throws FileNotFoundException {
        map = new HashMap<>();
        isEdgeVisited = new HashSet<>();
        Scanner sc = new Scanner(new File(fileName));
        colorSet = new HashSet<>();
        isNodevisited = new HashSet<>();
        while(sc.hasNext()){
            String[] s = sc.next().split(",");
            Integer src = Integer.parseInt(s[0]);
            Integer dest = Integer.parseInt(s[1]);
            addEdge(src,dest);
        }
    }

    public void addEdge(Integer src,int dest){
        List<Edge> list = new ArrayList<>();
        if(map.containsKey(src)){
            list = map.get(src);
        }
        Edge edge = new Edge(src,dest,-1);
        list.add(edge);
        map.put(src, list);
    }

    public boolean isColorable(int src){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        int color = 1;
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            List<Edge> list = map.get(v);
            if (list == null || list.isEmpty()) {
                continue;
            }
            for(Edge edge : list){
                if(isEdgeVisited.contains(edge) && edge.color == color){
                    return false;
                }

                while (colorSet.contains(color)) {
                    color++;
                }
                edge.color = color;
                isEdgeVisited.add(edge);
                queue.add(edge.dest);
                colorSet.add(color);
            }
        }
        return true;
    }


    public Set<Integer> getColor(){
        return colorSet;
    }



}

class Edge{
    Integer src;
    Integer dest;
    Integer color;

    public Edge(Integer src,Integer dest,Integer color){
        this.src = src;
        this.color = color;
        this.dest = dest;
    }
}