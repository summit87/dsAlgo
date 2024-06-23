package tree;
    /**
     *        1
            /   \
           2     3
         /   \
        4     5
     */

public class MorrisTraversal {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        morrisTraversal(tn.createMorissTree());
    }

    /**
     * Pre order traversal
     * @param treeNode
     */

    private static void morrisTraversal(TreeNode treeNode){
        while(treeNode != null){
            if(treeNode.getLeft() == null){
                System.out.print(treeNode.getData()+",");
                treeNode = treeNode.getRight();
            }else{
                TreeNode current = treeNode.getLeft();
                while(current.getRight() != null && current.getRight() != treeNode){
                    current = current.getRight();
                }
                if(current.getRight() == treeNode){
                    current.setRight(null);
                    treeNode = treeNode.getRight();
                }else{
                    System.out.print(treeNode.getData()+",");
                    current.setRight(treeNode);
                    treeNode = treeNode.getLeft();
                }

            }
        }
        
    }


    private static void morrisInorderTraversal(TreeNode tn){
        while(tn != null){
            if(tn.getLeft() == null){
                System.out.print(tn.getData()+",");
                tn = tn.getRight();
            }else{
                TreeNode current = tn.getLeft();
                while(current.getRight() != null && current.getRight() != tn){
                    current = current.getRight();
                }
                if(current.getRight() == tn){
                    current.setRight(null);
                    System.out.print(tn.getData()+",");
                    tn = tn.getRight();
                }else{
                    current.setRight(tn);
                    tn=tn.getLeft();
                }
            }
        }
    }

}


