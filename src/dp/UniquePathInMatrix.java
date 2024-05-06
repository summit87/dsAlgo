package dp;

public class UniquePathInMatrix {
	public static void main(String[] args){
		int m = 3;
		int n = 3;
		int r=1;
		int c=1;
		//System.out.println(path(m,n,r,c));
		System.out.println(pathDP(m, n));
	}

	private static int path(int row,int col,int c,int r){
		if(c > col || r > row){
			return 0;
		}
		if(c == col && r == row){
			return 1;
		}
		return path(row,col, c,r+1)+path(row,col,c+1,r);
	}

	private static int pathDP(int row,int col){
		int count=0;
		int[][] mat = new int[row+1][col+1];
		for(int i=0;i<col;i++){
			mat[0][i] = 1;
		}
		for(int j=0;j<row;j++){
			mat[j][0] = 1;
		}

		for(int i=1;i<row;i++){
			for(int j=1;j<col;j++){

				mat[i][j] = mat[i-1][j]+mat[i][j-1];
			}
		}

		return mat[row-1][col-1];
	}
}
