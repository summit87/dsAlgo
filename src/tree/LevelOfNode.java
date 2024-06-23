package tree;

public class LevelOfNode {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        System.out.println(level(tree.createMorissTree(), 1, 5));
    }

    private static int level(TreeNode tn, int level, int key) {
        if (tn == null) {
            return 0;
        }
        if (tn.getData() == key) {
            System.out.println(level);
            return level;
        }

        int l1 =  level(tn.getRight(), level + 1, key);
        if(l1 != 0){
            return l1;
        }
        l1 =  level(tn.getLeft(), level + 1, key);
        return l1;
    }
}
