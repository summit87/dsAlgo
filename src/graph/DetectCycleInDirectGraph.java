

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DetectCycleInDirectGraph {
    public static void main(String[] args) throws FileNotFoundException {
        Graph2 graph2 = new Graph2("cycle.txt");
        System.out.println(graph2.map().get(2));

        System.out.println(graph2.isCycleExistIn(0));
    }
}

class Graph2 {
    private Map<Integer, List<Integer>> mGraph;
    private Set<Integer> visitedSet;

    public Graph2(String fileName) throws FileNotFoundException {
        mGraph = new HashMap<>();
        visitedSet = new HashSet<>();
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String[] s = sc.nextLine().split(",");  
            addEdge(mGraph, Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }
        sc.close();
    }

    public Map<Integer, List<Integer>> map() {
        return mGraph;
    }

    public void addEdge(Map<Integer, List<Integer>> map, int src, int dest) {
        List<Integer> list = new ArrayList<>();

        if (map.containsKey(src)) {
            list = map.get(src);
        }
        list.add(dest);
        map.put(src, list);

    }

    public boolean isCycleExistIn(int src) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            if (visitedSet.contains(vertex)) {
                return true;
            }
            visitedSet.add(vertex);
            List<Integer> list = mGraph.get(vertex);
            if (list == null) {
                continue;
            }
            for (Integer ver : list) {
                queue.add(ver);
            }
        }

        return false;
    }

}
