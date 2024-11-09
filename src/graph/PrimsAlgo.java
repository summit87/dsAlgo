package graph;

public class PrimsAlgo {
    public static void main(String[] args) {
        int graph[][] = new int[][] {
                { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 }
        };
        int v = 5;
        prims(graph, v);

    }

    public static int minVertex(int[] key, boolean[] mSet) {
        int minIndex = 0;
        int minKey = Integer.MAX_VALUE;
        for (int v = 0; v < key.length; v++) {
            if (!mSet[v] && key[v] < minKey) {
                minIndex = v;
                minKey = key[v];
            }
        }
        return minIndex;
    }

    public static void prims(int[][] graph, int v) {
        int[] parent = new int[v];
        int[] key = new int[v];
        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
        }
        key[0] = 0;
        boolean[] mSet = new boolean[v];
        parent[0] = -1;
        for (int count = 0; count < v; count++) {
            int u = minVertex(key, mSet);
            mSet[u] = true;
            for (int vertex = 0; vertex < v; vertex++) {
                if (!mSet[vertex] && graph[u][vertex] != 0 && graph[u][vertex] < key[vertex]) {
                    key[vertex] = graph[u][vertex];
                    parent[vertex] = u;
                }
            }
        }
        printPath(key, parent, graph);
    }

    public static void printPath(int[] key, int[] parent, int[][] graph) {
        for (int i = 0; i < key.length; i++) {
            if (parent[i] >= 0)
                System.out.println("Src : " + parent[i] + "....... dest - " + i + " : " + graph[i][parent[i]]);
        }
    }
}
