package graph;

import java.util.*;


import java.io.File;
import java.io.FileNotFoundException;

public class Kruskal {
    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("krus.txt"));
        int v = sc.nextInt();
        int[] size = new int[v];
        int[] dst = new int[v];
        List<Edge> list = new ArrayList<>();
        while (sc.hasNext()) {
            String[] s = sc.next().split(",");
            int src = Integer.parseInt(s[0]);
            int dest = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            Edge e = new Edge(src,dest,weight);
            list.add(e);
            dst[src] = src;
            dst[dest] = dest;
            size[src] = 1;
            size[dest] = 1;
        }

        list.sort(Comparator.comparing(Edge::getWeight));

        for (Edge edge : list) {
            if (!makeSet(edge.getSrc(), edge.getDestination(), dst, size)) {
                System.out.println(edge.getSrc()+"......"+edge.getDestination()+"......weight : "+edge.getWeight());
            }
        }

    }

    private static boolean makeSet(int root1, int root2, int[] ds, int[] size) {
        int fRoot1 = findRoot(ds, root1);
        int fRoot2 = findRoot(ds, root2);
        if (fRoot1 == fRoot2) {
            return true;
        }

        if (size[fRoot1] <= size[fRoot2]) {
            ds[fRoot1] = fRoot2;
            size[fRoot2] += size[fRoot1];
        } else {
            ds[fRoot2] = fRoot1;
            size[fRoot1] += size[fRoot2];
        }
        return false;
    }

    public static int findRoot(int[] ds, int root) {
        if (root == ds[root]) {
            return root;
        }
        return findRoot(ds, ds[root]);

    }
    public static class Edge {
        private int src;
        private int dest;
        private int weight;
    
        public Edge(int src,int dest,int weight){
            this.weight = weight;
            this.src = src;
            this.dest = dest;
        }
    
        public int getWeight() {
            return weight;
        }
    
        public int getDestination() {
            return dest;
        }
    
        public int getSrc() {
            return src;
        }
    }
    
}

