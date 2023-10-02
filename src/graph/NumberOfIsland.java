package graph;

public class NumberOfIsland {
  static int c3 = 0;

  public static void main(String[] args) {
    int[][] mat = {
      {1, 1, 0, 0, 0},
      {0, 1, 0, 0, 1},
      {1, 0, 0, 1, 1},
      {0, 0, 0, 1, 1},
      {1, 0, 1, 0, 0}
    };
    int max = 0;
    boolean[][] vi = new boolean[5][5];
    int count = 0;
    int st = 0;
    int end = 0;
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        if (mat[i][j] == 1 && !vi[i][j]) {
          dfs(mat, vi, i, j, 5, 5);
          if (c3 > max) {
            max = c3;
          }
          c3 = 0;
          count++;
        }
      }
    }
    System.out.println(count);
    System.out.println(max);
    System.out.println(st + " : " + end);
  }

  static void dfs(int[][] mat, boolean[][] vi, int r, int c, int row, int col) {
    int[] r1 = {1, 1, 0, -1, -1, -1, 0, 1};
    int[] c1 = {0, -1, -1, -1, 0, 1, 1, 1};
    for (int i = 0; i < 8; i++) {
      if (isValidMove(mat, vi, r + r1[i], c + c1[i], row, col)) {
        vi[r + r1[i]][c + c1[i]] = true;
        c3++;
        dfs(mat, vi, r + r1[i], c + c1[i], row, col);
      }
    }
  }

  static boolean isValidMove(int[][] mat, boolean[][] vi, int r, int c, int row, int col) {
    return r >= 0 && r < row && c >= 0 && c < col && mat[r][c] == 1 && !vi[r][c];
  }
}
