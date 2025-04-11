package tree;

/**
 * Will check this problem in sometime
 * @author hydra
 */
public class AverageOfSubTree {
    static int countNode;
    static int totalNode;
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        PairNode p = avgTreeNode(tn.averageTree());
        System.out.println(p.getCount());
    }

    private static PairNode avgTreeNode(TreeNode tn){
        if(tn != null){
            PairNode pl = avgTreeNode(tn.getLeft());
            PairNode pr = avgTreeNode(tn.getRight());
            int sum = pl.getRootSum()+tn.getData()+pr.getRootSum();
            int child = 1;
            int totalChild = child+pl.getChildCount()+pr.getChildCount();
            int count = pl.getCount()+pr.getCount();
            if(sum/totalChild == tn.getData()){
                count = count+1;A
            }
            return new PairNode(totalChild, sum,count);
        }
        return new PairNode(0,0,0);
    }
}

class PairNode{
    private int child;
    private int totalRootNodeSum;
    private int count;

    public PairNode(int child,int totalRootNoeSum,int count){
        this.totalRootNodeSum = totalRootNoeSum;
        this.child = child;
        this.count = count;
    }

    public int getRootSum(){
        return totalRootNodeSum;
    }

    public int getChildCount(){
        return child;
    }

    public int getCount(){
        return count;
    }

    public void setRootSum(int sum){
        this.totalRootNodeSum = sum;
    }

    public void setChildCount(int count){
        this.child = count;
    }

    public void setCount(int count){
        this.count = count;
    }
}
