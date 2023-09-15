package tree;

import java.util.HashMap;
import java.util.Map;

public class FindHeightFromTreeOfArray {
	
	public static void main(String[] args) {
		int[] a = {-1, 0, 1, 6, 6, 0, 0, 2, 7};
		System.out.println(depthOfTree1(a));
	}
	
	private static int depthOfTheTree(int[] a) {
		int count = 0;
		int maxDepth = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			int j = i;
			count = 0;
			while (a[j] != -1) {
				count++;
				j = a[j];
			}
			if (maxDepth < count) {
				maxDepth = count;
			}
		}
		return maxDepth;
	}
	
	private static int depthOfTree1(int[] a) {
		int maxDepth = Integer.MIN_VALUE;
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			int j = i;
			count = 0;
			if (map.containsKey(a[j])) {
				count += (map.get(a[j]) + 1);
				if (maxDepth < count){
					maxDepth = count;
				}
				map.put(j, maxDepth);
			} else {
				count = 0;
				int p = a[j];
				if (p == -1) {
					map.put(j, count);
				} else {
					while (a[j] != -1) {
						count++;
						j = a[j];
					}
					if (maxDepth < count) {
						maxDepth = count;
					}
					map.put(p, maxDepth);
				}
				
			}
		}
		return maxDepth;
	}
	
}
