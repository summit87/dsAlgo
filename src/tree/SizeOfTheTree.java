package tree;

import java.util.Stack;

public class SizeOfTheTree {
	
	public static void main(String[] args) {
		TreeNode tn = new TreeNode();
		tn = tn.createBT1();
		System.out.println(size(tn));
	}
	
	private static int size(TreeNode tn) {
		if (tn == null) {
			return 0;
		}
		int left = size(tn.getLeft());
		int right = size(tn.getRight());
		if (left > right) {
			return left + 1;
		}
		return right + 1;
	}
	
	private static int sizeOfTree(TreeNode tn) {
		int maxSize = Integer.MIN_VALUE;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode current = tn;
		TreeNode temp = null;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				if (maxSize < stack.size()) {
					maxSize = stack.size();
				}
				temp = stack.peek().getRight();
				if (temp == null) {
					temp = stack.pop();
					while (!stack.isEmpty() && temp == stack.peek().getRight()) {
						temp = stack.pop();
					}
				} else {
					current = temp;
				}
			}
		}
		return maxSize;
	}
	
}
