package tree;

public class TreeNode {
    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }
    public TreeNode createBT(){
        TreeNode node = new TreeNode(50);
        node.setLeft(new TreeNode(20));
        node.setRight(new TreeNode(80));
        node.getLeft().setRight(new TreeNode(17));
        node.getLeft().setLeft(new TreeNode(15));
        node.getRight().setLeft(new TreeNode(19));
        return node;
    }
    
    public TreeNode createBT1(){
        TreeNode node = new TreeNode(50);
        node.setLeft(new TreeNode(20));
        node.setRight(new TreeNode(80));
        node.getLeft().setRight(new TreeNode(17));
        node.getLeft().getRight().setLeft(new TreeNode(23));
        node.getLeft().setLeft(new TreeNode(15));
        node.getLeft().getLeft().setLeft(new TreeNode(120));
        node.getLeft().getLeft().getLeft().setRight(new TreeNode(1));
        node.getRight().setLeft(new TreeNode(19));
        return node;
    }
    
    public TreeNode createBST() {
        TreeNode treeNode = new TreeNode(7);
        treeNode.setLeft(new TreeNode(2));
        treeNode.setRight(new TreeNode(9));
        treeNode.getLeft().setLeft(new TreeNode(1));
        treeNode.getLeft().setRight(new TreeNode(5));
        treeNode.getLeft().getRight().setLeft(new TreeNode(4));
        treeNode.getLeft().getRight().getLeft().setLeft(new TreeNode(3));
        treeNode.getLeft().getRight().setRight(new TreeNode(6));
        treeNode.getRight().setLeft(new TreeNode(8));
        treeNode.getRight().setRight(new TreeNode(13));
        treeNode.getRight().getRight().setRight(new TreeNode(14));
        treeNode.getRight().getRight().setLeft(new TreeNode(11));
        treeNode.getRight().getRight().getLeft().setLeft(new TreeNode(10));
        treeNode.getRight().getRight().getLeft().setRight(new TreeNode(12));
        return treeNode;
    }
    
    public void printTreeInOrder(TreeNode tn) {
        if (tn != null) {
            printTreeInOrder(tn.getLeft());
            System.out.print(tn.getData() + ",");
            printTreeInOrder(tn.getRight());
        }
    }
    
    

}
