package tree;

import java.util.Stack;
/*					50
				20		80
			  15  17   19
*/

// pre = 50
//current = 50
//50, 20 ,80

// prev=  80   , current = 80
// 50,20,80,19
// 19,80
// prev =  19  , current = 19
// 50,20,80

// prev =   80, current = 80
// 50,20

// prev =  , current = 20

public class PostOrder {
	
	public static void main(String[] args) {
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode tn = new TreeNode();
		tn = tn.createBT1();
		
		TreeNode prev = null;
		TreeNode current = tn;
		TreeNode temp = null;
		while (current != null || !stack.isEmpty()) {
			if (current != null) {
				stack.push(current);
				current = current.getLeft();
			} else {
				temp = stack.peek().getRight();
				if (temp == null) {
					temp = stack.pop();
					System.out.print(temp.getData() + ",");
					while (!stack.isEmpty() && temp == stack.peek().getRight()) {
						temp = stack.pop();
						System.out.print(temp.getData() + ",");
					}
				} else {
					current = temp;
				}
			}
		}
	}
	
}

