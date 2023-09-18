package tree;

public class InOrderPredecessor {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode = treeNode.createBST();
        TreeNode predecessorKey = new TreeNode(3);
        TreeNode pre = null;
        pre = inOrderPred(treeNode, predecessorKey, pre);
        if (pre != null) {
            System.out.println(pre.getData());
        }

    }

    private static TreeNode inOrderPred(TreeNode treeNode, TreeNode predecessorKey, TreeNode pre) {

        if (treeNode == null) {
            return null;
        }

        if (treeNode != null && treeNode.getLeft() != null && treeNode.getData() == predecessorKey.getData()) {
            TreeNode tn = treeNode.getLeft();
            while (tn.getRight() != null) {
                tn = tn.getRight();
            }
            pre = tn;
        } else if (treeNode != null && treeNode.getData() > predecessorKey.getData()) {
            return inOrderPred(treeNode.getLeft(), predecessorKey, pre);
        } else if (treeNode != null && treeNode.getData() < predecessorKey.getData()) {
            pre = treeNode;
            return inOrderPred(treeNode.getRight(), predecessorKey, pre);
        }

        return pre;
    }


}
