package tree;

public class BSTFromPreOrder {

    public static void main(String[] args) {
        int[] a = {10, 5, 1, 7, 40, 6};
        BST bst = bst(a, 0, a.length-1);
        
        preOrder(bst);
    }

    private static BST bst(int[] a, int left, int right) {
        if (left > right) {
            return null;
        }
        if (a.length <= 0) {
            return null;
        }
        if (left == right) {
            return new BST(a[left]);
        }
        int rootData = a[left];
        BST root = new BST(a[left]);
        int index = left;
        for (int x = left; x <= right; x++) {
            if (rootData < a[x]) {
                index = x;
                break;
            }
        }
        root.serLeft(bst(a, left+1, index));
        root.setRight(bst(a, index+1, right));
        return root;
    }

    private static void preOrder(BST bst) {
        if (bst != null) {
            System.out.print(bst.getData() + ",");
            preOrder(bst.getLeft());
            preOrder(bst.getRight());
        }
    }

}

class BST {

    private BST left;
    private BST right;
    private int data;

    public BST(int data) {
        this.data = data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void serLeft(BST left) {
        this.left = left;
    }

    public void setRight(BST right) {
        this.right = right;
    }

    public BST getRight() {
        return right;
    }

    public BST getLeft() {
        return left;
    }

    public int getData() {
        return this.data;
    }
}
