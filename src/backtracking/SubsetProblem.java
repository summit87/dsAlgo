package backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubsetProblem {
	
	public static void main(String[] args) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> subset = new ArrayList<>();
		int[] arr = new int[]{1, 2, 3};
		int index = 0;
		calculateSubsetProblem(index, res, subset, arr);
		System.out.println(res);
	}
	
	
	private static void calculateSubsetProblem(int index, List<List<Integer>> res,
		List<Integer> subset, int[] arr) {
		res.add(new ArrayList<>(subset));
		for (int i = index; i < arr.length; i++) {
			subset.add(arr[i]);
			calculateSubsetProblem(i + 1, res, subset, arr);
			subset.remove(subset.size() - 1);
		}
	}
	
}
