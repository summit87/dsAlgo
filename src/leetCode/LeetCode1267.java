package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LeetCode1267 {
    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,1,1},{1,0,0}};
        int[][] grid1 = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid1));
    }

    public static int countServers(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[] root = new int[row*col];
        int[] size = new int[row*col];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j] == 1){
                    int ind = (i*col)+(j);
                    root[ind] = ind;
                    size[ind] = 1;
                    queue.add(new int[]{ind,i,j});
                }
            }
        }
       
        while(!queue.isEmpty()){
            int[] ind  = queue.poll();
            for(int i=ind[1]+1;i < row;i++){
                if(grid[i][ind[2]] == 1){
                    union(root,size,ind[0],((i*col)+ind[2]));
                    break;
                }
            }

            for(int j=ind[1]-1;j>=0;j--){
                 if(grid[j][ind[2]] == 1){
                    union(root,size,ind[0],((j*col)+ind[2]));
                    break;
                }
            }

            for(int c = ind[2]+1;c<col;c++){
                if(grid[ind[1]][c] == 1){
                    union(root,size,ind[0],((ind[1]*col)+c));
                    break;
                }
            }

             for(int c = ind[2]-1;c>=0;c--){
                if(grid[ind[1]][c] == 1){
                    union(root,size,ind[0],((ind[1]*col)+c));
                    break;
                }
             }

        }

        int count=0;
        for(int i=0;i<row*col;i++){
            if(size[i] > 1){
                count+=size[i];
            }
        }


        return count;
    }

    public static int findRoot(int[] root,int src){
        if(root[src] == src){
            return src;
        }
        return findRoot(root,root[src]);
    }

    public static void union(int[]root,int[] size,int src1,int src2){
        int rs1 = findRoot(root,src1);
        int rs2 = findRoot(root,src2);
        if(rs1 == rs2){
            return;
        }

        if(size[rs1] < size[rs2]){
            root[rs1] = rs2;
            size[rs2] += size[rs1];
        }else if(size[rs2] < size[rs1]){
            size[rs1] += size[rs2];
            root[rs2] = rs1;
        }else{
            root[rs1] = rs2;
            size[rs2]+=size[rs1];
        }
        //return true;
    }
}
