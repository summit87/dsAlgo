package tree;

public class AVLTree {

    public static void main(String[] args) {
        AVLNode avln = new AVLNode(10);
        avln = insert(avln, 9);
        avln = insert(avln, 8);
        avln = insert(avln, 7);
        print(avln);        

    }

    public static int height(AVLNode avlnode) {
        if (avlnode == null) {
            return 0;
        }
        return 1 + avlnode.getHeight();
    }

    public static AVLNode insert(AVLNode avlNode, int data) {
        if (avlNode == null) {
            avlNode = new AVLNode(data);
            avlNode.setLeft(null);
            avlNode.setRight(null);
            avlNode.setHeight(0);
        } else {
            if (data < avlNode.getData()) {
                avlNode.setLeft(insert(avlNode.getLeft(), data));
                if (height(avlNode.getLeft()) - height(avlNode.getRight()) == 2) {
                    // do rotation single left end
                    if (data < avlNode.getLeft().getData()) {
                        avlNode = singleRotationLeft(avlNode);
                    } else {
                        avlNode = doubleRotationLeft(avlNode);
                    }
                    avlNode.setHeight(Math.max(height(avlNode.getLeft()), height(avlNode.getRight())) + 1);
                }
            } else if (data > avlNode.getData()) {
                insert(avlNode.getRight(), data);
                if (height(avlNode.getRight()) - height(avlNode.getLeft()) == 2) {
                    if (data < avlNode.getRight().getData()) {
                        avlNode = singleRotationRight(avlNode);
                    } else {
                        avlNode = doubleRotationRight(avlNode);
                    }
                }
                avlNode.setHeight(Math.max(height(avlNode.getLeft()), height(avlNode.getRight())) + 1);
            }
        }
        return avlNode;
    }

    public static AVLNode singleRotationLeft(AVLNode avln) {
        AVLNode left = avln.getLeft();
        avln.setLeft(left.getRight());
        left.setRight(avln);
        return left;
    }

    public static AVLNode singleRotationRight(AVLNode avln) {
        AVLNode right = avln.getRight();
        right.setRight(right.getRight());
        avln.setLeft(right);
        return right;
    }

    public static AVLNode doubleRotationLeft(AVLNode avln) {
        avln.setLeft(singleRotationLeft(avln.getLeft()));
        return singleRotationLeft(avln);
    }

    public static AVLNode doubleRotationRight(AVLNode avln) {
        avln.setRight(singleRotationRight(avln.getRight()));
        return singleRotationRight(avln);
    }

    public static void print(AVLNode avln){
        if(avln == null){
            return;
        }
        print(avln.getLeft());
        System.out.print(avln.getData()+",");
        print(avln.getRight());
    }

}

class AVLNode {

    private Integer data;
    private AVLNode left;
    private AVLNode right;
    private Integer height;

    public AVLNode(int data) {
        this.data = data;
    }

    public void setLeft(AVLNode left) {
        this.left = left;
    }

    public void setRight(AVLNode right) {
        this.right = right;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public AVLNode getLeft() {
        return this.left;
    }

    public AVLNode getRight() {
        return this.right;
    }

    public int getHeight() {
        return this.height;
    }

    public int getData() {
        return this.data;
    }

}
