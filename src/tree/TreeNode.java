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

    public TreeNode createNode(TreeNode node, Integer data) {
        TreeNode tn = new TreeNode(data);
        if (node == null) {
            node = tn;
            return node;
        }
        tn.setLeft(createNode(node.getLeft(), data));
        tn.setRight(createNode(node.getRight(), data));
        return tn;
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

}
