package backtracking;

public class CountNumberOfWays {
	
	public static void main(String[] args) {
		int[][] mat = { {0, 0, 0, 0},
						{0, -1, 0, 0},
						{-1, 0, 0, 0},
						{0, 0, 0, 0}
					  };
		int row = 4;
		int col = 4;
		int x = 0;
		int y = 0;
		System.out.println(count(mat, x, y, row, col));
	}
	
	private static int count(int[][] mat, int x, int y, int row, int col) {
		if (x == col - 1 && y == row - 1 && mat[x][y] == 0) {
			return 1;
		}
		if (x >= col || y >= row || mat[x][y] != 0) {
			return 0;
		}
		return count(mat, x + 1, y, row, col) + count(mat, x, y + 1, row, col);
	}
	// Time calculation
	// The time complexity of this solution is O(2^N), where N is the number of cells in the matrix.
	
	private static boolean isValid(int[][] mat, int x, int y, int row, int col) {
		return (x >= 0 && x < col && y >= 0 && y < row && mat[x][y] == 0);
	}
}
