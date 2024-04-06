package backtracking;

public class KnightSolution {
  public static void main(String[] args) {

  }

  private static boolean isSafe(int[][] mat, int row, int col, int n) {

    for (int i = 0; i < col; i++) {
      if (mat[row][i] == 1) {
        return false;
      }
    }

    for (int i = row, j = col; j >= 0 && i >= 0; i--, j--) {
      if (mat[i][j] == 1) {
        return false;
      }
    }
    for (int i = row, j = col; j >= 0 && i < n; i++, j--) {
      if (mat[i][j] == 1) {
        return false;
      }
    }
    return true;
  }

  private static boolean solution(int[][] mat, int row, int col, int n) {
    if(col == n-1){
      return true;
    }
    for (int i=0;i<n;i++){
      if(isSafe(mat,i,col,n)){
        mat[i][col] =1;
        if(solution(mat,i,col+1,n)){
          return true;
        }
        mat[i][col] =0;
      }
    }
    return false;
  }
}
