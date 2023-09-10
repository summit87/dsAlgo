package backtracking;

public class RatInMaze {
	
	public static void main(String[] args) {
		int[][] mat = {{1, 0, 0, 0},
			{1, 1, 0, 1},
			{0, 1, 0, 0},
			{1, 1, 1, 1}};
		int col = 4;
		int row = 4;
		int[][] sol = new int[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				sol[i][j] = 0;
			}
		}
		
		if (ratInMaze(mat, 0, 0, row, col, sol)) {
			System.out.println("Solution exist");
		} else {
			System.out.println("Solution does not exist");
		}
		
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(sol[i][j] + ",");
			}
			System.out.println();
		}
	}
	
	private static boolean ratInMaze(int[][] mat, int x, int y, int row, int col, int[][] sol) {
		if (x == col - 1 && y == row - 1) {
			sol[x][y] = 1;
			return true;
		}
		if (sol[x][y] == 1) {
			return false;
		}
		int[] x1 = {1, 0};
		int[] y1 = {0, 1};
		for (int i = 0; i < 2; i++) {
			int x2 = x + x1[i];
			int y2 = y + y1[i];
			if (isValid(mat, x2, y2, row, col)) {
				sol[x][y] = 1;
				if (ratInMaze(mat, x2, y2, row, col, sol)) {
					return true;
				} else {
					sol[x][y] = -1;
				}
			}
		}
		return false;
	}
	
	private static boolean isValid(int[][] mat, int x, int y, int row, int col) {
		return (x >= 0 && x < col && y >= 0 && y < row && mat[x][y] == 1);
	}
	
}
