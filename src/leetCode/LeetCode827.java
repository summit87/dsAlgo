package leetCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Make largest island after converting at most one zero
 */
public class LeetCode827 {

    public static void main(String[] args) {
        int[][] mat = {
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 1, 1, 0, 1, 1 },
                { 0, 0, 1, 0, 0 },
                { 0, 0, 1, 1, 1 },
                { 0, 0, 1, 1, 1 }
        };
        int totalCell = mat[0].length * mat.length;
        int[] root = new int[totalCell + 1];
        int[] size = new int[totalCell + 1];
        Set<Integer> visited = new HashSet<>();
        int[] r1 = { 0, 1, 0, -1 };
        int[] c1 = { 1, 0, -1, 0 };
        for (int i = 0; i <= totalCell; i++) {
            root[i] = i;
            size[i] = 1;
        }
        for (int r = 0; r < mat.length; r++) {
            for (int c = 0; c < mat[r].length; c++) {
                int cellNumber = colNumber(r, c, mat);
                if (!visited.contains(cellNumber) && mat[r][c] == 1) {
                    connectAllTheCell(r, c, mat, root, size, visited, r1, c1);
                }
            }
        }

       
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0) {
                     visited = new HashSet<>();
                    for (int k = 0; k < 4; k++) {
                        if (isValid1(i + r1[k], j + c1[k], mat) && mat[i + r1[k]][j + c1[k]] == 1) {
                            int cellN = colNumber(i + r1[k], j + c1[k], mat);
                            int src = findRoot(cellN, root);
                            visited.add(src);
                        }
                    }

                    int totalSize = 0;
                    Iterator<Integer> it = visited.iterator();
                    while(it.hasNext()){
                        totalSize+=size[it.next()];
                    }
                    max = Math.max(max, totalSize+1);
                }
            }
        }


        System.out.println(max);

    }

    public static void connectAllTheCell(int r, int c, int[][] mat, int[] root, int[] size, Set<Integer> visited,
            int[] r1, int[] c1) {

        Queue<Pair1> q = new LinkedList<>();
        q.add(new Pair1(r, c));
        while (!q.isEmpty()) {
            Pair1 p = q.poll();
            visited.add(colNumber(p.r, p.c, mat));
            for (int i = 0; i < 4; i++) {
                if (!isValid(p.r + r1[i], p.c + c1[i], mat, visited)) {
                    continue;
                }
                if (visited.contains(colNumber(p.r + r1[i], p.c + c1[i], mat))) {
                    continue;
                }
                int root1 = colNumber(p.r, p.c, mat);
                int root2 = colNumber(p.r + r1[i], p.c + c1[i], mat);
                Pair1 p1 = new Pair1(p.r + r1[i], p.c + c1[i]);
                q.add(p1);
                union(root, size, root1, root2);
            }
        }
    }

    public static Integer colNumber(int r, int c, int[][] mat) {
        return ((mat[0].length * r) + c);
    }

    public static boolean isValid(int r, int c, int[][] mat, Set<Integer> visited) {
        int cellNumber = colNumber(r, c, mat);
        return isValid1(r, c, mat)
                && !visited.contains(cellNumber);
    }

    public static boolean isValid1(int r, int c, int[][] mat) {
        return r >= 0 && c >= 0 && r < mat.length && c < mat[0].length && mat[r][c] == 1;
    }

    public static int findRoot(int src, int[] root) {
        if (root[src] == src) {
            return src;
        }
        return findRoot(root[src], root);
    }

    public static void union(int[] root, int[] size, int r1, int r2) {
        int src1 = findRoot(r1, root);
        int src2 = findRoot(r2, root);

        if (src1 == src2) {
            return;
        }

        if (size[src1] < size[src2]) {
            root[src1] = src2;
            size[src2] += size[src1];
        } else {
            root[src2] = src1;
            size[src1] += size[src2];
        }
    }

}

class Pair1 {
    int r;
    int c;

    public Pair1(int r, int c) {
        this.c = c;
        this.r = r;
    }
}
