package tree;

public class DecendentNode {
    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        PairNode2 p = decendNode(tn.tree2());
        System.out.println(p.getCount());
    }

    private static PairNode2 decendNode(TreeNode tn){
        if(tn == null){
            return new PairNode2(0, 0) ;
        }
        if(tn.getLeft() == null && tn.getRight() == null){
            return new PairNode2(tn.getData(), 0);
        }
        PairNode2 left = decendNode(tn.getLeft());
        PairNode2 right = decendNode(tn.getRight());
        int count = left.getCount()+right.getCount();
        if(tn.getData() - (left.getSum()+right.getSum()) == 0){
            count++;
        }
        return new PairNode2((left.getSum()+right.getSum()+tn.getData()), count);
    }


}

class PairNode2{
    private int sum;
    private int count;
    public PairNode2(int sum,int count){
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
