package tree;

public class DecendentNode {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        PairNode1 p = decendNode(tn.tree2());
        System.out.println(p.getCount());
    }

    private static PairNode1 decendNode(TreeNode tn){
        if(tn == null){
            return new PairNode1(0, 0) ;
        }
        if(tn.getLeft() == null && tn.getRight() == null){
            return new PairNode1(tn.getData(), 0);
        }
        PairNode1 left = decendNode(tn.getLeft());
        PairNode1 right = decendNode(tn.getRight());
        int count = left.getCount()+right.getCount();
        if(tn.getData() - (left.getSum()+right.getSum()) == 0){
            count++;
        }
        return new PairNode1((left.getSum()+right.getSum()+tn.getData()), count);
    }


}

class PairNode1{
    private int sum;
    private int count;
    public PairNode1(int sum,int count){
        this.sum = sum;
        this.count = count;
    }

    public void setSum(int sum){
        this.sum = sum;
    }
    public void setCount(int count){
        this.count = count;
    }

    public int getSum(){
        return this.sum;
    }

    public int getCount(){
        return this.count;
    }
}
