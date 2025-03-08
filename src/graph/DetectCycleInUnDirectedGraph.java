package graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class DetectCycleInUnDirectedGraph {
    /**
     * visite this again
     * @param args
     * @throws FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        // Graph4 graph4 = new Graph4("g4.txt");        
        // System.out.println(graph4.isCycle(0));
        System.out.println(('z'-97));
    }
}

class Graph4{
    private Map<Integer,List<Integer>> map;
    private Set<Integer> visited;
    public Graph4(String fileName) throws FileNotFoundException{
        map = new HashMap<>();
        visited = new HashSet<>();
        Scanner sc = new Scanner(new File(fileName));
        while(sc.hasNext()){
            String[] s = sc.next().split(",");
            addEdge(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
    }

    public void addEdge(Integer src,Integer dest){
        List<Integer> list = new ArrayList<>();
        if(map.containsKey(src)){
            list = map.get(src);
        }
        list.add(dest);
        map.putIfAbsent(src, list);
    }

    public boolean isCycle(Integer src){
        visited.add(src);
        List<Integer> list = map.get(src);
        if (list == null) {
            return false;
        }

        for(Integer ver : list){
            if(!visited.contains(ver) && isCycle(ver)){
                return true;
            }
            if(src != ver){
                return true;
            }

        }
        return false;
    }


}
