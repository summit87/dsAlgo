package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PrintPathFromSrcToDesti {
    public static void main(String[] args) throws FileNotFoundException {
        Graph5 graph5 = new Graph5("g6.txt");
        graph5.findPath(0, 3);
        // graph5.print(0);
        // graph5.findAllPath(0, 3, new ArrayList<>(), new HashSet<>());
    }
}

class Graph5 {
    private Map<Integer, List<Integer>> map;
    Set<Integer> visited;
    int[] path;
    int v = 0;

    public Graph5(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        v = sc.nextInt();
        path = new int[v];
        map = new HashMap<>();
        visited = new HashSet<>();
        init();
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            Integer src = Integer.parseInt(s[0]);
            Integer dest = Integer.parseInt(s[1]);
            addEdge(src, dest);
        }
    }

    public void addEdge(int src, int dest) {
        List<Integer> list = new ArrayList<>();
        if (map.containsKey(src)) {
            list = map.get(src);
        }

        list.add(dest);
        map.put(src, list);
    }

    /**
     * BFS approach to find the path from source to destination , need to optimize this
     * 
     * @param src
     * @param dest
     */
    public void findPath(int src, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        if (src == dest) {
            System.out.println("No path");
            return;
        }
        while (!queue.isEmpty()) {
            int v = queue.poll();
            List<Integer> list = map.get(v);
            visited.add(v);
            for (int v1 : list) {
                if (!visited.contains(v1)) {
                    queue.add(v1);
                    path[v1] = v;
                }

                if (v1 == dest) {
                    print(src);
                    System.out.println();
                    init();
                }
            }
        }
    }

    private void init() {
        for (int i = 0; i < v; i++) {
            path[i] = -1;
        }
    }

    public void print(int src) {
        for (int i = 0; i < v; i++) {
            if (path[i] >= 0) {
                System.out.print(path[i] + ",");
            }
        }
    }

    public void findAllPath(int src, int dest, List<Integer> list, Set<Integer> visited) {
        if (src == dest) {
            printPath(list);
            System.out.println();
        }
        visited.add(src);
        List<Integer> list1 = map.get(src);
        for (int ch : list1) {
            if (!visited.contains(ch)) {
                list.add(ch);
                findAllPath(ch, dest, list, visited);
                list.remove(list.size() - 1);
            }
        }
        visited.remove(src);

    }

    private void printPath(List<Integer> list) {
        for (Integer p : list) {
            System.out.print(p + ",");
        }
    }

}
