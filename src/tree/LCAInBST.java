package tree;


public class LCAInBST {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        tn = tn.createBST1();
        TreeNode lca = lca(tn,new TreeNode(8),new TreeNode(14));
        if (lca != null){
            System.out.println(lca.getData());
        }


    }

    private static TreeNode lca(TreeNode treeNode, TreeNode min, TreeNode max) {
        if (treeNode == null) {
            return null;
        }
        if (min.getData() <= treeNode.getData() && max.getData() >= treeNode.getData()) {
            return treeNode;
        }
        if (min.getData() < treeNode.getData() && max.getData() < treeNode.getData()) {
            return lca(treeNode.getLeft(), min, max);
        }
        return lca(treeNode.getRight(), min, max);
    }
}
