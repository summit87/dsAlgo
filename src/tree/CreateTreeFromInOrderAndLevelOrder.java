package tree;

import java.util.HashSet;
import java.util.Set;

public class CreateTreeFromInOrderAndLevelOrder {

    public static void main(String[] args) {
        int[] inOrder = {4, 8, 10, 12, 14, 20, 22}; ;
        int[] level =  {20, 8, 22, 4, 12, 10, 14};
        TreeNode tn = createTreeNode1(inOrder, level, 0, inOrder.length-1);
        tn.printTreeInOrder(tn);
    }

    private static TreeNode createTree(int[] level, int[] inOrder, int st, int end) {
        if (st > end) {
            return null;
        }

        if (st == end) {
            return new TreeNode(inOrder[st]);
        }

        boolean flag = false;
        int ind = st;
        for (int i = 0; i < level.length; i++) {
            flag = false;
            for (int j = st; j < end; j++) {
                if (level[i] == inOrder[j]) {
                    flag = true;
                    ind = j;
                    break;
                }
            }
            if (flag == true) {
                break;
            }
        }
        if(flag == false){
            return null;
        }

        TreeNode tn = new TreeNode(inOrder[ind]);

        tn.setLeft(createTree(level, inOrder, st, ind-1));
        tn.setRight(createTree(level, inOrder, ind+1 , end));
        return tn;
    }


    /**
     * In this approach , first we are indetifying the element of the left subtree and rightSubTree
     * Set : we are putting all those element who is potential candidate for left subTree,
     * 
     * @param inOrder
     * @param levelOrder
     * @param st
     * @param end
     * @return
     */

    private static TreeNode createTreeNode1(int[] inOrder,int[] levelOrder,int st,int end){
        if(st > end){
            return null;
        }

        if(st == end){
            return new TreeNode(inOrder[st]);
        }

        int index = st;
        /**
         * We are storing all those element who is porential candidate for left sub tree
         * 
         */
        Set<Integer> set = new HashSet<>();
        for(;index<= end;index++){
            if(levelOrder[0] == inOrder[index]){
                break;
            }
        }

        for(int i=st;i<index;i++){
            set.add(inOrder[i]);
        }
        int[] lLevel = new int[set.size()]; 
        // Why we can't we do int[] lLevel = new int[index]; , 
        //the reason is that, we always start index from start , 
        //then we may creating the arrat size less than the actual size, e.g if st = 3 and end = 4, then index = 3, and end 4
        // then end-st-ind < 0, which is wrong
        int[] rLevel = new int[end-st-set.size()];
        int rIndex = 0;
        int lIndex = 0;
        /**
         * We are taking i from i , because we alaready consider the index 0 at line number 77
         * lLevel : taking all the element form original array of levelOrder array and adding into left sub tree
         */
        for(int i=1;i<levelOrder.length;i++){
            if(set.contains(levelOrder[i])){
                lLevel[lIndex++] = levelOrder[i];
            }else{
                rLevel[rIndex++] = levelOrder[i];
            }
        }
        TreeNode tn = new TreeNode(inOrder[index]);
        tn.setLeft(createTreeNode1(inOrder, lLevel, st, index-1));
        tn.setRight(createTreeNode1(inOrder, rLevel, index+1, end));
        return tn;
    }
}
