package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import dp.LIS;;

public class StronglyConnectedComponenet {
    public static void main(String[] args) throws FileNotFoundException {
        Graph6 graph6 = new Graph6("ap.txt");
        List<Integer> list = new ArrayList<>();
        graph6.scc();
    }
}

class Graph6 {
    private Map<Integer, List<Integer>> map;
    private Set<Integer> visited;
    int v = 0;
    private int[] low;
    private int[] desc;
    private int time = 0;

    public Graph6(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        map = new HashMap<>();
        visited = new HashSet<>();
        v = sc.nextInt();
        low = new int[v];
        desc = new int[v];
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

    public void scc(int src, List<Integer> list, int[] tree, int[] discovery, Set<Integer> vis, Stack<Integer> stack) {
        tree[src] = time;
        discovery[src] = time;
        time = time + 1;
        vis.add(src);
        stack.push(src);
        List<Integer> nodes = map.get(src);
        if (nodes == null) {
            return;
        }
        for (Integer node : nodes) {
            if (!vis.contains(node)) {
                scc(node, list, tree, discovery, vis, stack);
                tree[src] = Math.min(tree[src], tree[node]);
                if (tree[src] < tree[node]) {
                    list.add(src);
                }
            } else {
                /**
                 * This condition will cover backedge of b/w the nodes
                 */
                tree[src] = Math.min(tree[src], discovery[node]);
            }
        }
        if (low[src] == discovery[src]) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + ",");
            }
        }
        System.out.println();
    }

    public void scc() {
        for (int i = 0; i < v; i++) {
            low[i] = -1;
            desc[i] = -1;
        }
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (Integer i = 0; i < v; i++) {
            if (desc[i] == -1) {
                scc(i, list, low, desc, visited, stack);
            }
        }

        System.out.println(list);

    }

    public void printEdge(List<Integer> list) {
        System.out.println(list);
    }

}
