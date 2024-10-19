package backtracking;

public class MColoring {
	public static void main(String[] args) {
		int[][] mat = { { 0, 1, 1, 1 },
				{ 1, 0, 1, 0 },
				{ 1, 1, 0, 1 },
				{ 1, 0, 1, 0 } };
		int c = 3;
		int[] color = new int[4];
		if (isMcolor(0, mat, 4, color, c)) {
			for (int i = 0; i <4 ; i++) {
				System.out.print(color[i] + ",");
			}
			System.out.println("Coloring is possible");
		}
	}

	private static boolean isSafe(int[][] mat, int src, int v, int c, int[] color) {
		for (int i = 0; i < v; i++) {
			if (mat[src][i] == 1 && c == color[i]) {
				return false;
			}
		}
		return true;
	}

	public static boolean isMcolor(int src, int[][] mat, int v, int[] color, int chromoticNumber) {
		if (src == v) {
			return true;
		}

		for (int i = 1; i <= chromoticNumber; i++) {
			if (isSafe(mat, src, v, i, color)) {
				color[src] = i;
				if (isMcolor(src + 1, mat, v, color, chromoticNumber)) {
					return true;
				}
				color[src] = 0;
			}
		}
		return false;
	}
}
