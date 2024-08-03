package tree;

public class HeightOfTree {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        System.out.println(height(tn.createTree1()));
    }

    public static  int height(TreeNode tn){
        if(tn == null){
            return 0;
        }

        int left = 1+ height(tn.getLeft());
        int right = 1+height(tn.getRight());
        return left > right ? left :right;
    }

    
}
