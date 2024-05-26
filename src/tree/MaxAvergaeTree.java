package tree;

public class MaxAvergaeTree {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        PairNode1 p = maxAverageTreeNode(tn.averageTree3());
        System.out.println(p.getMaxAverageNode().getData());
    }

    private static PairNode1 maxAverageTreeNode(TreeNode tn){
        if(tn == null){
            return new PairNode1(0,Integer.MIN_VALUE,0,null);
        }
        PairNode1 pl = maxAverageTreeNode(tn.getLeft());
        PairNode1 pr = maxAverageTreeNode(tn.getRight());
        int child = 1 + pl.getChild()+pr.getChild();
        int sum = pl.getRootSum()+pr.getRootSum()+tn.getData();
        double avg = sum/child;
        TreeNode avgTreeNode = tn ;
        if(avg < pl.getMaxAverage()){
            avg = pl.getMaxAverage();
            avgTreeNode = pl.getMaxAverageNode();
        }
        if(avg < pr.getMaxAverage()){
            avg = pr.getMaxAverage();
            avgTreeNode = pr.getMaxAverageNode();
        }
        return new PairNode1(child, avg, sum, avgTreeNode);

    }
}

class PairNode1{
    private int child;
    private double  maxAverage;
    private int rootSum;
    private  TreeNode maxAverageNode;

    public PairNode1(int child,double maxAverage,int rootSum,TreeNode maxAverageNode){
        this.child = child;
        this.maxAverage = maxAverage;
        this.rootSum = rootSum;
        this.maxAverageNode = maxAverageNode;
    }

    public int getChild(){
        return this.child;
    }

    public double getMaxAverage(){
        return this.maxAverage;
    }

    public TreeNode getMaxAverageNode(){
        return this.maxAverageNode;
    }

    public int getRootSum(){
        return this.rootSum;
    }
}
