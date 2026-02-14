package tree;

public class TreeNode {

    private Integer data;
    private TreeNode left;
    private TreeNode right;

    public TreeNode() {
    }

    public TreeNode(Integer data) {
        this.data = data;
        this.left = null;
        this.right = null;
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

    public TreeNode createBT() {
        TreeNode node = new TreeNode(50);
        node.setLeft(new TreeNode(20));
        node.setRight(new TreeNode(80));
        node.getLeft().setRight(new TreeNode(17));
        node.getLeft().setLeft(new TreeNode(15));
        node.getRight().setLeft(new TreeNode(19));
        return node;
    }

    public TreeNode createBT1() {
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
            if (tn.getData() != null) {
                System.out.print(tn.getData() + ",");
            }
            printTreeInOrder(tn.getRight());
        }
    }

    /**
     * node* root = newNode(20); root->left = newNode(8); root->right =
     * newNode(22); root->left->left = newNode(4); root->left->right =
     * newNode(12); root->left->right->left = newNode(10);
     * root->left->right->right = newNode(14);
     *
     * @return
     */
    public TreeNode createBST1() {
        TreeNode tn = new TreeNode(20);
        tn.setLeft(new TreeNode(8));
        tn.setRight(new TreeNode(22));
        tn.getLeft().setLeft(new TreeNode(4));
        tn.getLeft().setRight(new TreeNode(20));
        tn.getLeft().getRight().setLeft(new TreeNode(10));
        tn.getLeft().getRight().setRight(new TreeNode(14));
        return tn;
    }

    /**
     * 1
     * / \
     * 2 3
     * / \
     * 4 5
     *
     * @return
     */
    public TreeNode createMorissTree() {
        TreeNode tn = new TreeNode(1);
        tn.setLeft(new TreeNode(2));
        tn.setRight(new TreeNode(3));
        tn.getLeft().setLeft(new TreeNode(4));
        tn.getLeft().setRight(new TreeNode(5));
        return tn;
    }

    /**
     *
     * @return
     */
    public TreeNode averageTree() {
        TreeNode tn = new TreeNode(4);
        tn.setLeft(new TreeNode(8));
        tn.setRight(new TreeNode(5));
        tn.getLeft().setLeft(new TreeNode(0));
        tn.getLeft().setRight(new TreeNode(1));
        tn.getRight().setRight(new TreeNode(6));
        return tn;
    }

    public TreeNode averageTree1() {
        TreeNode tn = new TreeNode(0);
        return tn;
    }

    public TreeNode averageTree2() {
        TreeNode tn = new TreeNode(0);
        tn.setLeft(new TreeNode(0));
        tn.setRight(new TreeNode(0));
        return tn;
    }

    public TreeNode averageTree3() {
        TreeNode tn = new TreeNode(5);
        tn.setLeft(new TreeNode(3));
        tn.setRight(new TreeNode(8));
        return tn;
    }

    public TreeNode tree() {
        TreeNode tn = new TreeNode(10);
        tn.setLeft(new TreeNode(20));
        tn.setRight(new TreeNode(5));
        tn.getRight().setLeft(new TreeNode(9));
        tn.getLeft().setRight(new TreeNode(6));
        tn.getLeft().setLeft(new TreeNode(5));
        tn.getLeft().getLeft().setRight(new TreeNode(20));
        return tn;
    }

    public TreeNode tree1() {
        TreeNode tn = new TreeNode(10);
        tn.setLeft(new TreeNode(3));
        tn.setRight(new TreeNode(4));
        tn.getLeft().setLeft(new TreeNode(2));
        tn.getLeft().setRight(new TreeNode(1));
        return tn;
    }

    public TreeNode tree2() {
        TreeNode tn = new TreeNode(10);
        tn.setLeft(new TreeNode(4));
        tn.setRight(new TreeNode(3));
        tn.getLeft().setLeft(new TreeNode(2));
        tn.getLeft().setRight(new TreeNode(1));
        return tn;
    }

    public TreeNode bst1() {
        TreeNode tn = new TreeNode(11);
        tn.setLeft(new TreeNode(2));
        tn.setRight(new TreeNode(29));
        tn.getLeft().setLeft(new TreeNode(1));
        tn.getLeft().setRight(new TreeNode(7));
        tn.getRight().setLeft(new TreeNode(15));
        tn.getRight().setRight(new TreeNode(40));
        tn.getRight().getRight().setLeft(new TreeNode(35));
        return tn;
    }

    public TreeNode bst2() {
        TreeNode tn = new TreeNode(9);
        tn.setLeft(new TreeNode(6));
        tn.setRight(new TreeNode(15));
        tn.getLeft().setLeft(new TreeNode(3));
        tn.getRight().setRight(new TreeNode(21));
        return tn;
    }

    public TreeNode createTree1(){
        TreeNode tn = new TreeNode(10);
        tn.setLeft(new TreeNode(5));
        tn.getLeft().setLeft(new TreeNode(1));
        tn.getLeft().setRight(new TreeNode(8));
        tn.setRight(new TreeNode(15));
        tn.getRight().setRight(new TreeNode(9));
        return tn;
    }


    public TreeNode createTree2(){
        TreeNode tn = new TreeNode(50);
        tn.setLeft(new TreeNode(75));
        tn.getLeft().setLeft(new TreeNode(45));
        tn.setRight(new TreeNode(45));
        return tn;
    }


     public static TreeNode createTree3(){
        TreeNode tn = new TreeNode(5);
        tn.setLeft(new TreeNode(4));
        tn.getLeft().setLeft(new TreeNode(11));
        tn.getLeft().getLeft().setLeft(new TreeNode(7));
        tn.getLeft().getLeft().setRight(new TreeNode(2));
        tn.setRight(new TreeNode(8));
        tn.getRight().setLeft(new TreeNode(13));
        tn.getRight().setRight(new TreeNode(4));
        tn.getRight().getRight().setRight(new TreeNode(1));
        return tn;
    }


    public static TreeNode createTree5(){
        TreeNode tn = new TreeNode(3);
        tn.setLeft(new TreeNode(9));
        tn.setRight(new TreeNode(20));
        tn.getRight().setLeft(new TreeNode(15));
        tn.getRight().setRight(new TreeNode(7));
        return tn;
    }

}
