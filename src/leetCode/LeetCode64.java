package leetCode;

public class LeetCode64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
    }

     public static int minPathSum(int[][] grid) {

        for(int i=1;i<grid.length;i++){
            grid[0][i] += grid[0][i-1]; 
        }

         for(int i=1;i<grid[0].length;i++){
            grid[i][0] += grid[i-1][0]; 
        }
        for(int i=1;i<grid.length;i++){
            for(int j=1;j<grid[0].length;j++){
                int x1 = grid[i-1][j];
                int x2 = grid[i][j-1];
                grid[i][j]+=Math.min(x1,x2);

            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }

        return grid[grid.length-1][grid[0].length-1];
    }
}
