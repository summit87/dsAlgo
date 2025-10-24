package tree;

import java.util.Stack;

public class PrintPathSum {
    public static void main(String[] args) {
        TreeNode treeNode = TreeNode.createTree3();
        Stack stack = new Stack<>();
        if (isPathSum(treeNode, 18, stack)) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop()+",");
            }
        }
    }

    private static boolean isPathSum(TreeNode tn, int targetSum, Stack<Integer> st) {
        if (tn != null) {
            st.push(tn.getData());
            targetSum = targetSum + ((-1) * tn.getData());
            if (targetSum == 0 && tn.getLeft() == null && tn.getRight() == null) {
                return true;
            }
            boolean b = isPathSum(tn.getLeft(), targetSum, st) || isPathSum(tn.getRight(), targetSum, st);
            if (b == true) {
                return true;
            }
            if (!st.isEmpty()) {
                st.pop();
            }
        }

        return false;
    }
}
