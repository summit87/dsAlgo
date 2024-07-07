package tree;

import java.util.Stack;

public class KthLargestElement {

    static int count=0;
    public static void main(String[] args) {
        TreeNode tn = new TreeNode().bst1();
        tn.printTreeInOrder(tn);
        kthLargest(tn, 4);
        System.out.println(iterative(tn,4));
    }

    private static void kthLargest(TreeNode tn,int kth){
        if(tn == null){
            return;
        }

        kthLargest(tn.getLeft(),kth);
        count++;
        if(kth == count){
            System.out.println(String.format("kth %s largest element %d", kth,tn.getData()));
            return;
        }
        kthLargest(tn.getRight(), kth);

    }

    private static int iterative(TreeNode tn,int kth){
        Stack<TreeNode> stack = new Stack<>();
        
        while( tn != null || !stack.isEmpty() || kth >0){
            if(tn != null){
                stack.push(tn);
                tn = tn.getLeft();
            }else{
                tn = stack.pop();
                kth--;
                if(kth == 0){
                    return tn.getData();
                }
                tn = tn.getRight();
            }
        }

       return -1;
    }
}
