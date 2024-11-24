package tree;

public class SegmentTree {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 11,20};
        int[] tree = new int[2 * a.length+1];
        buildTree(tree, 0, 0, a.length - 1, a);
        int newVal = 23;
        int diff = newVal - a[2];
        for(int i=0;i<tree.length;i++){
            System.out.print(tree[i]+",");
        }
        System.out.println();
        a[2] = newVal;
        
        System.out.println(getSum(tree, 0, 0, a.length - 1, 2, 4));
        updateTree(tree, 0, 0, a.length-1, diff, 2);
        System.out.println(getSum(tree, 0, 0, a.length - 1, 2, 4));
        
    }

    public static void buildTree(int[] tree, int iIndex, int st, int end, int[] arr) {
        if (st > end) {
            return;
        }

        if (st == end) {
            tree[iIndex] = arr[st];
        } else {
            int mid = st + ((end - st) / 2);
            buildTree(tree, 2 * iIndex + 1, st, mid, arr);
            buildTree(tree, 2 * iIndex + 2, mid + 1, end, arr);
            tree[iIndex] = tree[2 * iIndex + 1] + tree[2 * iIndex + 2];
        }
    }

    public static int getSum(int[] tree, int iIndex, int st, int end, int l, int r) {

        if (l <= st && r >= end) {
            return tree[iIndex];
        }

        if (l > end || r < st) {
            return 0;
        }

        int mid = st + ((end - st) / 2);
        return getSum(tree, 2 * iIndex + 1, st, mid, l, r) + getSum(tree, 2 * iIndex + 2, mid + 1, end, l, r);

    }

    public static  void updateTree(int[] tree, int iIndex, int st, int end, int diff, int updatedIndex) {
        if(st == updatedIndex || end == updatedIndex){
            tree[iIndex] = tree[iIndex]+diff;
        }
        int mid = st+((end-st)/2);
        
        if(st != end){
            updateTree(tree,2*iIndex+1,st,mid,diff,updatedIndex);
            updateTree(tree,2*iIndex+2,mid+1,end,diff,updatedIndex);
            tree[iIndex] = tree[2*iIndex+1]+tree[2*iIndex+2];
        }
    }
}