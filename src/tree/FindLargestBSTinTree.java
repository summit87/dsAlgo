package tree;

public class FindLargestBSTinTree {

    public static void main(String[] args) {
        TreeNode tn = new TreeNode();
        System.out.println(maxSize(tn.createTree2(),Integer.MIN_VALUE,Integer.MAX_VALUE).getSize());
    }

    public static NodeVal maxSize(TreeNode tn,int min,int max){
        if(tn == null){
            return new NodeVal(0);
        }

        NodeVal left = maxSize(tn.getLeft(), min,tn.getData());
        NodeVal right = maxSize(tn.getRight(),tn.getData(), max);

        if(tn.getData() < min || tn.getData() > max){
            return new NodeVal(Math.max(left.getSize(), right.getSize()));
        }

        return new NodeVal(1+Math.max(left.getSize(), right.getSize()));

    } 

}

class NodeVal {

    private Integer size;

    public NodeVal( Integer size) {
    
        this.size = size;
    }

    public Integer getSize() {
        return size;
    }
}
