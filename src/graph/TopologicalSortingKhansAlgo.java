
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TopologicalSortingKhansAlgo {
    public static void main(String[] args) throws FileNotFoundException {
        Graph10 graph10 = new Graph10("topo.txt");
        graph10.topological();
        System.out.println(graph10.order);
    }
}

class Graph10{
    Map<Integer, List<Integer>> map;
    Set<Integer> set;
    Stack<Integer> stack;
    Integer vertex;
    Map<Integer,Integer> inDegree;
    Queue<Integer> queue;
    List<Integer> order;
    public Graph10(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        map = new HashMap<>();
        stack = new Stack<>();
        vertex = sc.nextInt();
        set = new HashSet<>();
        order = new LinkedList<>();
        queue = new LinkedList<>();
        inDegree = new HashMap<>();
        for(int i=0;i<vertex;i++){
            inDegree.put(i,0);
        }
        while (sc.hasNext()) {
            String[] st = sc.next().split(",");
            Integer src = Integer.parseInt(st[0]);
            Integer dest = Integer.parseInt(st[1]);
            addEdge(src, dest);
        }
        
    }

    public void addEdge(Integer src, Integer dest) {

        List<Integer> list = new ArrayList<>();
        if (map.containsKey(src)) {
            list = map.get(src);
        }
        int ind = inDegree.get(dest)+1;
        inDegree.put(dest, ind);
        list.add(dest);
        map.put(src, list);
    }

    public void topological(){
        for(int i=0;i<vertex;i++){
            if (inDegree.containsKey(i) && inDegree.get(i) == 0) {
                queue.add(i);
            }
        }
        topologicalUtil();
    }

    private void topologicalUtil(){
        int total = 0;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (inDegree.containsKey(v) && inDegree.get(v) == 0) {
                order.add(v);
            }
            total++;
            List<Integer> list = map.get(v);
            if (list == null) {
                continue;
            }
           
            set.add(v);
            for(Integer ver: list){
                // if(inDegree.get(ver) > 0 && set.contains(ver)){
                //     System.out.println("Cycle exsit "+v+" : "+ver);
                // }
                if(inDegree.containsKey(ver) && inDegree.get(ver) > 0){
                    int val = inDegree.get(ver);
                    val = val -1;
                    inDegree.put(ver, val);
                    if (val == 0) {
                        queue.add(ver);
                    }
                }
            }
        }
        System.out.println(total);
    }

}
