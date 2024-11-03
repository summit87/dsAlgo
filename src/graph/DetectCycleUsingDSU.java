package graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class DetectCycleUsingDSU {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(isCycle("cyc1.txt"));
    }

    public static boolean isCycle(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        int v = scanner.nextInt();
        int[] size = new int[v];
        int[] set = new int[v];
        for (int i = 0; i < v; i++) {
            set[i] = i;
            size[i]=1;
        }

        while (scanner.hasNext()) {
            String[] s = scanner.next().split(",");
            int src = Integer.parseInt(s[0]);
            int dest = Integer.parseInt(s[1]);
            int fRoot1 = find(src, set);
            int fRoot2 = find(dest, set);
            System.out.println("fRoot1 > "+fRoot1+" : fRoot2 > "+fRoot2);
            if (fRoot1 == fRoot2) {
                return true;
            }
            makeSet(set, size, fRoot1, fRoot2);

        }

        for (int i = 0; i < v; i++) {
            System.out.println(i + " : " + size[i]);
        }

        return false;
    }

    public static void makeSet(int[] set, int[] size, int fRoot1, int fRoot2) {

        if (size[fRoot1] <= size[fRoot2]) {
            size[fRoot2] += size[fRoot1];
            set[fRoot1] = fRoot2;
        } else {
            size[fRoot1] += size[fRoot2];
            set[fRoot2] = fRoot1;
        }
    }

    public static int find(int nodeVal, int[] set) {
        if (nodeVal == set[nodeVal]) {
            return nodeVal;
        }

        if (set[nodeVal] == -1) {
            return nodeVal;
        }

        return find(set[nodeVal], set);
    }

}
