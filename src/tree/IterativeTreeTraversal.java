package tree;

import java.util.Stack;

public class IterativeTreeTraversal {
    public static void main(String[] args) {
        //inOrderIterative(new TreeNode().createMorissTree());
        preOrderIterativeTraversal(new TreeNode().createMorissTree());
    }

    public static void inOrderIterative(TreeNode node){
        Stack<TreeNode> stack = new Stack();
        while(node != null || !stack.isEmpty()){
            while(node != null){
                stack.push(node);
                node = node.getLeft();
            }

            node = stack.pop();
            System.out.print(node.getData()+",");
            node = node.getRight();
        }
    }

    public static void preOrderIterativeTraversal(TreeNode tn){
        Stack<TreeNode> stack = new Stack<>();
        while(tn != null || !stack.isEmpty()){
            while(tn != null){
                stack.push(tn);
                System.out.print(tn.getData()+",");
                tn = tn.getLeft();
            }

            tn = stack.pop().getRight();
        }
    }

    


}
