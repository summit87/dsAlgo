package tree;

public class MaxHeight {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        System.out.println(maxHeight(treeNode.createMorissTree()));
    }

    private static int maxHeight(TreeNode tn){

        if(tn == null){
            return 0;
        }
        int lh = 1+maxHeight(tn.getLeft());
        int rh = 1+maxHeight(tn.getRight());
        return lh > rh ? lh : rh;
    }
}
