package graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfConnectedComponent {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        int[][] edges={{0,1},{1,2},{3,4}};
        int n = 5;
        int[] root = new int[n];
        int[] size = new int[n];
        for(int ind =0;ind <n; ind++){
            root[ind] = ind;
            size[ind] = 1;
        }
        for(int[] edge : edges){
            dsu(root,size,edge[0],edge[1]);
        }

        System.out.println(count(root, n));
    }

    public static int count(int[] root,int n){
        int cnt = 0;
        boolean[] visited = new boolean[n];
        for(int ind = 0;ind < n;ind++){
            int src = findRoot(root, ind);
            if(visited[src]){
                continue;
            }
            visited[src] = true;
            cnt++;
        }
        return cnt;
    }

    public static void dsu(int[] root,int[] size,int src,int dest){
        int srcRoot = findRoot(root, src);
        int destRoot = findRoot(root, dest);
        if(srcRoot == dest){
            return;
        }
        if(size[srcRoot] < size[destRoot]){
            root[srcRoot] = destRoot;
            size[destRoot]+=size[srcRoot];
            return;
        }
        root[destRoot] = srcRoot;
        size[srcRoot]+=size[destRoot];
    }

    public static int findRoot(int[] root,int src){
        if(root[src] == src){
            return src;
        }
        return findRoot(root,root[src]);
    }
}
