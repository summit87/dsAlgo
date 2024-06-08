package tree;

public class SumOfAllLeafNode {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        System.out.println(sumOfLeafNode(tn.tree()));
    }

    private static int sumOfLeafNode(TreeNode tn){
        if(tn == null){
            return 0;
        }

        if(tn.getLeft() == null && tn.getRight() == null){
            return tn.getData();
        }

        return sumOfLeafNode(tn.getLeft())+sumOfLeafNode(tn.getRight());
    }
}
