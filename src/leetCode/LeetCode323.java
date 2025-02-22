package leetCode;

import java.util.*;

public class LeetCode323 {
    public static void main(String[] args) {
        int n = 3;
        int[][] edges ={{0,0},{0,1},{1,2}};
        System.out.println(count(edges, n));
    }

    public static int count(int[][] edges,int n){
       
        int[] root = new int[n];
       
        for(int i=0;i<n;i++){
            root[i] = i;
        }
        for(int[] edge : edges){
            n-=union(root, edge);
        }
        return n;
    }

    public static int findRoot(int[] root,int src){
        if(root[src] ==  src){
            return src;
        }
        return findRoot(root,root[src]);
    }

    public static int union(int[] root,int[] nodes){
        int root0 = findRoot(root, nodes[0]);
        int root1= findRoot(root, nodes[1]); 
        if(root0 == root1){
            return 0;
        }
        root[root0] = root1;
        return 1;
    }
}