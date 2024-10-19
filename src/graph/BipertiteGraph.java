package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
/**
 * This algoritham we can use in two clique problem
 * to identify two click problem , first we take the transpose of the given graph
 * (In the transpose of the graph, we will add the edge between the node which doesn't have prior to transpose)
 * then in transpose graph we will run the biprertit logic 
 */
public class BipertiteGraph {
    public static void main(String[] args) throws FileNotFoundException {
        Graph7 graph7 = new Graph7("g7.txt");
        System.out.println(graph7.isBipertite(0));
    }
}

class Graph7 {
    private Map<Integer, List<Integer>> map;
    private Set<Integer> visited;
    private char[] color;

    public Graph7(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int v = scanner.nextInt();
        color = new char[v];
        map = new HashMap<>();
        visited = new HashSet<>();
        while (scanner.hasNext()) {
            String[] s = scanner.next().split(",");
            Integer src = Integer.parseInt(s[0]);
            Integer dest = Integer.parseInt(s[1]);
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

    public boolean isBipertite(int src) {
        char ch = 'R';
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        color[src] = ch;
        while (!queue.isEmpty()) {
            Integer ver = queue.poll();
            List<Integer> nodes = map.get(ver);
            
            visited.add(ver);
            if(nodes.isEmpty()){
                continue;
            }
            for (Integer node : nodes) {
                if (visited.contains(node)) {
                    if (color[node] == color[ver]) {
                        return false;
                    }
                    continue;
                }
                queue.add(node);
                color[node] = (color[ver] == 'R' ? 'B' : 'R');
                ch = (ch == 'R') ? 'B' : 'R';
            }
        }
        return true;
    }
}
