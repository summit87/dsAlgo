package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;;

/**
 * floyd warshal algoritham works for below use case for both connected and
 * disconnected graph
 * 1. Finding shortest distance b/w the vertex
 * 2. finding -ive edge in the graph ,
 * The below implementation is bellman ford algoritham to find the -ive edge in
 * the graph
 * this algoritham will work only for connected graph for finding the -ive edge
 * in to graph
 * Bellman-Ford algorithm will fail if the graph contains any negative edge
 * cycle.
 */

public class DetectNegativeCyce {
    public static void main(String[] args) throws FileNotFoundException {

        /**
         * calculate minimum dist
         * Graph3 graph3 = new Graph3("dij.txt");
         * Map<Character,Integer> minDist = graph3.calculateMinDistMapping('A');
         */

        char[] ch = { 'A' };
        Graph3 gr = new Graph3("negativeWeightDija.txt");
        for (Character ch1 : ch) {
            if (gr.isNegativeWeightCycle(ch1)) {
                System.out.println("Negative cycle exist from source : " + ch1);
            }
        }

    }

    private static void calculateMinDist(Graph3 graph3) {
        Map<Character, Integer> minDist = graph3.calculateMinDistMapping('A');
        for (Map.Entry<Character, Integer> map : minDist.entrySet()) {
            System.out.print(map.getKey() + "," + map.getValue());
        }
    }
}

class Graph3 {
    private Map<Character, List<WeightNode>> map;
    Map<Character, Integer> minDist;
    Set<Character> isVisisted;
    List<SourceDest> edge;

    public Graph3(String fileName) throws FileNotFoundException {
        minDist = new HashMap<>();
        isVisisted = new HashSet<>();
        map = new HashMap<>();
        edge = new ArrayList<>();
        Scanner sc = new Scanner(new File(fileName));
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            addEdge(s[0].charAt(0), s[1].charAt(0), Integer.parseInt(s[2]));
            minDist.put(s[0].charAt(0), Integer.MAX_VALUE);
            minDist.put(s[1].charAt(0), Integer.MAX_VALUE);
            SourceDest sourceDest = new SourceDest();
            sourceDest.src = s[0].charAt(0);
            sourceDest.dest = s[1].charAt(0);
            sourceDest.weight = Integer.parseInt(s[2]);
            edge.add(sourceDest);
        }
    }

    public void addEdge(Character src, Character dest, Integer weight) {
        List<WeightNode> list = new ArrayList<>();
        if (map.containsKey(src)) {
            list = map.get(src);
        }
        WeightNode weightNode = new WeightNode();
        weightNode.node = dest;
        weightNode.weight = weight;
        list.add(weightNode);
        map.put(src, list);
    }

    public boolean isNegativeWeightCycle(Character src) {
        Map<Character, Integer> midDistMapp = calculateMinDistMapping(src);
        /**
         * for finding the -ive cycle in graph , once we calculate the minimum distant
         * for each vertex ,
         * then again by traversing each edge in the graph , if again dist(src)+weight <
         * dist(dest), then -vi cycl exist
         */
        for (SourceDest sourceDest : edge) {
            char s = sourceDest.src;
            char d = sourceDest.dest;
            Integer weight = sourceDest.weight;
            if (minDist.get(s) != Integer.MAX_VALUE && midDistMapp.get(s) + weight < midDistMapp.get(d)) {
                return true;
            }
        }

        return false;
    }

    public Map<Character, Integer> calculateMinDistMapping(Character src) {
        // TODO Auto-generated method stub
        char[] ch2 = { 'A', 'B', 'C', 'D', 'E', 'F' };
        ;
        for (char ch1 : ch2) {
            minDist.put(ch1, Integer.MAX_VALUE);
        }
        WeightNode wn = new WeightNode();
        wn.node = src;
        wn.weight = 0;
        minDist.put(src, 0);
        Queue<WeightNode> queue = new LinkedList<>();
        queue.add(wn);
        isVisisted = new HashSet<>();
        while (!queue.isEmpty()) {
            WeightNode wn1 = queue.poll();
            isVisisted.add(wn1.node);
            List<WeightNode> list = map.get(wn1.node);
            if (list == null || list.isEmpty()) {
                continue;
            }
            for (WeightNode ch : list) {
                if (isVisisted.contains(ch.node)) {
                    continue;
                }
                int srcDist = minDist.get(wn1.node);
                int dest = minDist.get(ch.node);
                int weight = ch.weight;
                int finalDest = Math.min((srcDist + weight), dest);
                minDist.put(ch.node, finalDest);
                queue.add(ch);
            }
        }
        return minDist;
    }

    public Map<Character, List<WeightNode>> getGraph() {
        return map;
    }
}

class WeightNode {
    public Character node;
    public Integer weight;
}

class SourceDest {
    public char src;
    public char dest;
    public Integer weight;
}
