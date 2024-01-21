package graph;

public class DetectCycle {
  public static void main(String[] args) {
    int[][] edges = {
      {1, 2},
      {2, 3},
      {3, 4},
      {3, 6},
      {4, 5},
      {1, 5}
    };

    int n = 6;
    if (isCycle(edges, n)) {
      System.out.println("Exist");
    } else {
      System.out.println("Not exist");
    }
  }

  static int find(int[] set, int vertex) {
    if (vertex >= set.length && vertex < 0) {
      return -1;
    }
    if (set[vertex] == vertex) {
      return vertex;
    }
    return find(set, set[vertex]);
  }

  static void makeSet(int[] set, int[] size, int s, int d) {
    int n1 = find(set, s);
    int n2 = find(set, d);
    if (n1 == -1 || n2 == -1) {
      return;
    }
    if (size[n1] <= size[n2]) {
      set[n2] = n1;
      size[n1]++;
    } else {
      set[n1] = n2;
      size[n2]++;
    }
  }

  static boolean isCycle(int[][] edges, int n) {
    int[] set = new int[n + 1];
    int[] size = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      size[i] = 1;
      set[i] = i;
    }
    for (int i = 0; i < n; i++) {
      int s = edges[i][0];
      int d = edges[i][1];
      if (find(set, s) == find(set, d)) {
        return true;
      }
      makeSet(set, size, s, d);
    }
    return false;
  }
}
