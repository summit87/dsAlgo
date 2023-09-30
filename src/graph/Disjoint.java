package graph;

public class Disjoint {
    public static void main(String[] args) {
        int n = 10;
        int[] size = new int[n + 1];
        int[] ds = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            size[i] = 1;
            ds[i] = i;
        }
        union(ds, size, 1, 3);
        union(ds, size, 2, 3);
        union(ds, size, 7, 6);
        union(ds, size, 5, 6);
        union(ds, size, 9, 7);
        union(ds, size, 4, 7);
        union(ds, size, 10, 5);
        union(ds, size, 3, 6);
        System.out.println(find(ds, 10));

    }

    static int find(int[] dis, int nodeVal) {
        if (nodeVal >= dis.length || nodeVal < 0) {
            return -1;
        }
        if (dis[nodeVal] == nodeVal) {
            return nodeVal;
        }
        /**
         * in case of compressed tree we can optimize with below code
         * return find(dis, dis[dis[nodeVal]]);
         */
        return find(dis, dis[nodeVal]);
    }

    static void union(int[] ds, int[] size, int root1, int root2) {
        int r1 = find(ds, root1);
        int r2 = find(ds, root2);
        if (r1 == -1 || r2 == -1) {
            return;
        }
        if (size[r1] <= size[r2]) {
            ds[r1] = r2;
            size[r2]++;
        } else {
            ds[r2] = r1;
            size[r1]++;
        }
    }
}
