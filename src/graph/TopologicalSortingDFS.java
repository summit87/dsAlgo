import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * 
 * Assuming there is no cycle in the graph
 * 
 *  */ 

public class TopologicalSortingDFS {
    public static void main(String[] args) throws FileNotFoundException {
        Graph9 graph9 = new Graph9("topo.txt");
        graph9.topological();
        graph9.printOrder();
    }
}

class Graph9 {
    Map<Integer, List<Integer>> map;
    Set<Integer> set;
    Stack<Integer> stack;
    Integer vertex;

    public Graph9(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        map = new HashMap<>();
        stack = new Stack<>();
        vertex = sc.nextInt();
        set = new HashSet<>();
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
        list.add(dest);
        map.put(src, list);
    }

    public void topological() {
        for (int i = 0; i < vertex; i++) {
            if (!set.contains(i)) {
                topologicalUtil(i);
            }
        }
    }

    private void topologicalUtil(int src) {
        // TODO Auto-generated method stub
        set.add(src);
        List<Integer> list = map.get(src);
        if (list != null) {
            for (Integer ver : list) {
                if (!set.contains(ver)) {
                    topologicalUtil(ver);
                }
            }
        }
        stack.push(src);
    }

    public void printOrder() {
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ",");
        }
    }
}
