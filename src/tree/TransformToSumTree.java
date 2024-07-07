package tree;

public class TransformToSumTree {

    static int sum = 0;
    public static void main(String[] args) {
        TreeNode tn = new TreeNode().bst2();
        tn.printTreeInOrder(tn);
        System.out.println();
        //greaterSum(tn);
        smallerSumTree(tn);
        tn.printTreeInOrder(tn);
    }

    private static void greaterSum(TreeNode tn) {
        if (tn == null) {
            return;
        }
        greaterSum(tn.getRight());
        int val = tn.getData();
        tn.setData(sum);
        sum += val;
        greaterSum(tn.getLeft());
    }

    private static void smallerSumTree(TreeNode tn){
        if(tn == null){
            return;
        }

        smallerSumTree(tn.getLeft());
        int val = tn.getData();
        tn.setData((val+sum));
        sum += val;
        smallerSumTree(tn.getRight());
    }
}
