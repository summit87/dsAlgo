package leetCode;

public class LeetCode980 {

    static int path=0;
    public static void main(String[] args) {
        int[][] grid =  {{1,0,0,0},{0,0,0,0},{0,0,2,-1}};
        int startRow = 0;
        int startCol = 0;
        int noOfMovableCell=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] ==1){
                    startRow=i;
                    startCol=j;
                } if(grid[i][j] == 0){
                    noOfMovableCell++;
                }
            }
        }
        /**
         * Why we are using noOfMovableCell :
         * A robot can only reach destination if and only if the robot
         * walking in four direction , so if robot moves all four directin
         * then he must go in all the cell , robot can't reach destination
         * by going into alleast two direction, this is invalid  moves
         */
        boolean[][] moved = new boolean[grid.length][grid[0].length];
        countWithBackTracking(grid, grid.length, grid[0].length, startRow, startCol, moved, noOfMovableCell);
        System.out.println(path);

    }


    public static boolean isValidCell(int row,int col,int r,int c,boolean[][] moved,int[][] grid){
        return r>=0 && r < row && c >= 0 && c < col && !moved[r][c] && grid[r][c] >= 0;
    }

    public static void countWithBackTracking(int[][] grid,int row,int col,int r,int c,boolean[][] moved,int noOfMovable){
        if(grid[r][c] == 2 && noOfMovable == 1){
            path++;
            return;
        }

        int[] r1 = {0,1,0,-1};
        int[] c1 = {1,0,-1,0};

        noOfMovable--;
        moved[r][c] = true;
        for(int i=0;i<4;i++){
            int r2 = r+r1[i];
            int c2 = c+c1[i];
            if(isValidCell(row, col, r2, c2, moved, grid)){
                countWithBackTracking(grid, row, col, r2, c2, moved, noOfMovable);
            }
        }
        moved[r][c] = false;
    }


    public int countWithBackTracking1(int[][] grid, int row,int col,int r,int c,int noOfMoves){
        


        return 0;
    }
}
