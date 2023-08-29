package tree;

import java.util.Stack;

public class InOrder {
    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node = node.createBT();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = node;
        while (true) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            if (stack.isEmpty()) {
                break;
            } else {
                TreeNode pop = stack.pop();
                System.out.print(pop.getData() + ",");
                currentNode = pop.getRight();
            }


        }
    }
}
