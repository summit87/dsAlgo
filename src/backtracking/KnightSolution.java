package backtracking;

public class KnightSolution {
  public static void main(String[] args) {
    int n=4;
    int[][] mat = new int[n][n];
    int[] ld = new int[n*n];
    int[] rd = new int[n*n];
    int[] cl = new int[n*n];
    for (int i=0;i<n;i++){
      for (int j=0;j<n;j++){
        mat[i][j] = 0;
//        ld[i+(j*n)] = -1;
//        rd[i+(j*n)] = -1;
      }
    }
    /**
     * 0 0 1 0
     * 1 0 0 0
     * 0 0 0 1
     * 0 1 0 0
     * 1 0 0 0 0
     * 0 0 0 1 0
     * 0 1 0 0 0
     * 0 0 0 0 1
     * 0 0 1 0 0
     * 0 0 0 1 0 0
     * 1 0 0 0 0 0
     * 0 0 0 0 1 0
     * 0 1 0 0 0 0
     * 0 0 0 0 0 1
     * 0 0 1 0 0 0
     */
//    for (int i = 0; i < mat.length; i++) {
//        if(solution(mat,i,n)){
//          System.out.println("solution found...");
//          for (int j=0;j<n;j++){
//            for (int k=0;k<n;k++){
//              System.out.print(mat[j][k]+" ");
//            }
//          System.out.println();
//          }
//        }
//        return;
//      }

    for (int i = 0; i < mat.length; i++) {
      if(solution1(mat,i,n,ld,rd,cl)){
        System.out.println("solution found...");
        for (int j=0;j<n;j++){
          for (int k=0;k<n;k++){
            System.out.print(mat[j][k]+" ");
          }
          System.out.println();
        }
      }
      //return;
    }
    for (int i=0;i<n;i++){
     for (int j=0;j<n;j++){
        System.out.print(ld[i+(j*n)]+",");
     }
      System.out.println();
    }
    System.out.println("RD..........");
    for (int i=0;i<n*n;i++){
      System.out.print(rd[i]+",");
    }


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

  private static boolean solution(int[][] mat ,int col, int n) {
    if(col >= n){
      return true;
    }
    for (int i=0;i<n;i++){
      if(isSafe(mat,i,col,n)){
        mat[i][col] =1;
        if(solution(mat,col+1,n)){
          return true;
        }
        mat[i][col] =0;
      }
    }
    return false;
  }

  private static boolean solution1(int[][] mat ,int col, int n,int[] ld,int[] rd,int[] cl) {
    if(col >= n){
      return true;
    }
    for (int i=0;i<n;i++){
      if(ld[i-col+n-1] != (i-col+n-1) && rd[i+col] !=(i+col)&& cl[i]!=1){
        mat[i][col] =1;
        ld[i-col+n-1] = i-col+n-1;
        rd[i+col] = i+col;
        cl[i] = 1;
        if(solution1(mat,col+1,n,ld,rd,cl)){
          return true;
        }
        mat[i][col] =0;
        ld[i-col+n-1] = 0;
        rd[i+col] = 0;
        cl[i] = 0;
      }
    }
    return false;
  }
}
