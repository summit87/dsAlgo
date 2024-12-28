package leetCode;

import java.util.PriorityQueue;
import java.util.*;

public class LeetCode1631 {
    public static void main(String[] args) {
        
        int[][] mat = {{1,2,3},
                       {3,8,4},
                       {5,3,5}};
        int[][] diffMatrix = new int[mat.length][mat[0].length];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                diffMatrix[i][j] = Integer.MAX_VALUE;
            }
        }
        diffMatrix[0][0] = 0;
        pq.add(new int[]{0,0,0});
        int[] c = {0,1,0,-1};
        int[] r = {1,0,-1,0};
        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            for(int i =0;i < c.length ; i++){
                int r1 = cell[1]+r[i];
                int c1 = cell[0]+c[i];
                if(r1 >= 0 && c1 >= 0 && c1 < mat[0].length && r1 < mat.length){
                    int diff =  Math.max(cell[2],Math.abs(mat[cell[1]][cell[0]] - mat[r1][c1]));
                    if(diffMatrix[r1][c1] > diff){
                        diffMatrix[r1][c1] = diff;
                        pq.add(new int[]{c1,r1,diff});
                    }
                }
            }
        
        }
        System.out.println(diffMatrix[2][2]);
    }
}
