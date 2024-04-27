package backtracking;

import java.util.Stack;

public class RatInMaze1 {
  public static void main(String[] args) {
    int[][] maze = {{1, 0, 0, 0},
                    {1, 1, 0, 1},
                    {1, 1, 0, 0},
                    {0, 1, 1, 1}};
    boolean[][] visited = new boolean[maze.length][maze[0].length];
    StringBuffer stringBuffer = new StringBuffer();
    int n = maze.length;
    move(maze,visited,n,0,0,"");
    System.out.println(stringBuffer.toString());
  }

  private static boolean isSafe(int[][] mat, int N, int r, int c,boolean[][] vi) {
    return (c >= 0 && c < N && r >= 0 && r < N && mat[r][c] == 1 && !vi[r][c]);
  }
  public static void move(int[][] mat,boolean[][] vi,int n,int r,int c,String sb) {
    if (r == n-1 && c == n-1) {
      System.out.println(sb);
      return;
    }
    int[] c1 = {1,0,-1,0};
    int[] r1 = {0,-1,0,1};
    for (int i=0;i<4;i++){
      int c2 = c+c1[i];
      int r2 = r+r1[i];
      char ch=' ';
      if (c1[i] ==1 && r1[i]== 0){
        ch = 'R';
      }else if(c1[i] == 0 && r1[i] == -1){
        ch='U';
      }else if(c1[i] == -1 && r1[i] == 0){
        ch='L';
      }else {
        ch = 'D';
      }
      if (isSafe(mat,n,r2,c2,vi)){
        vi[r2][c2] = true;
        move(mat,vi,n,r2,c2,sb+String.valueOf(ch).trim());
        vi[r2][c2] = false;
      }
    }
  }

}


class Point{
  private int x;
  private int y;

  Point(int x,int y){
    this.x=x;
    this.y=y;
  }
  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }
}