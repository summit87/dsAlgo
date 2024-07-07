package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTreeTraversal {
    public static void main(String[] args) {
        //inOrderIterative(new TreeNode().createMorissTree());
       // preOrderIterativeTraversal(new TreeNode().createMorissTree());
       // postOrderWithTwoStack(new TreeNode().createMorissTree());
        postOrderTraversalWith1Stack(new TreeNode().createMorissTree());
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

    public static void postOrderWithTwoStack(TreeNode tn){
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(tn);
        while(!st1.isEmpty()){
            TreeNode tn1 = st1.pop();
            st2.push(tn1);
            if(tn1.getLeft()!= null){
                st1.push(tn1.getLeft());
            }
            if(tn1.getRight() != null){
                st1.push(tn1.getRight());
            }
        }

        while(!st2.isEmpty()){
            System.out.print(st2.pop().getData()+",");

        }
    }

    /**
     *        1
            /   \
           2     3
         /   \
        4     5
     * @return
     */

    public static void postOrderTraversalWith1Stack(TreeNode tn){
        Stack<TreeNode> st1 = new Stack<>();
        List<TreeNode> list = new ArrayList();
        TreeNode prev = null;
        while(tn != null || !st1.isEmpty()){
            if(tn != null){
                st1.push(tn);
                tn = tn.getLeft();
            }else{
                tn = st1.peek();
                /**
                 * This if condition will handle the case if we have one child in the right of the node
                 */
                if(tn.getRight() == null || tn.getRight() == prev){
                    st1.pop();
                    list.add(tn);
                    prev = tn;
                    tn = null;
                }else{
                    tn = tn.getRight();
                }
            }
        }
        list.forEach(tn2 ->{
            System.out.print(tn2.getData()+",");
        });
    }

    


}
