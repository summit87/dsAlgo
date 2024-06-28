package tree;

public class SegmentMaximuInGivenRange {

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7, 9, 9, 2, 1};
        MaxPairCount[] tree = new MaxPairCount[4 * a.length];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new MaxPairCount(0, 0);
        }
        buildTree(tree, 0, 0, a.length - 1, a);

        MaxPairCount maxVal = getMaxNumberWithOccurence(tree, 0, a.length - 1, 0, 0, 5);
        System.out.println(maxVal.getVal()+" : "+maxVal.getCount());

    }

    public static void buildTree(MaxPairCount[] tree, int v, int st, int end, int[] arr) {
        if (st > end) {
            return;
        }

        if (st == end) {
            tree[v] = new MaxPairCount(arr[st], 1);
        } else {
            int mid = st + ((end - st) / 2);
            buildTree(tree, 2 * v + 1, st, mid, arr);
            buildTree(tree, 2 * v + 2, mid + 1, end, arr);
            tree[v] = maxValCount(tree[2 * v + 1], tree[2 * v + 2]);
        }
    }

    public static MaxPairCount getMaxNumberWithOccurence(MaxPairCount[] tree, int st, int end, int v, int l, int r) {

        if (l > end || r < st) {
            return new MaxPairCount(Integer.MIN_VALUE, 0);
        }

        if(l <= st && r >= end){
            return tree[v];
        }

        int mid = st + ((end - st) / 2);
        return maxValCount(getMaxNumberWithOccurence(tree, st, mid, 2 * v + 1, l, r),
                getMaxNumberWithOccurence(tree, mid + 1, end, 2 * v + 2, l, r));

    }

    public static MaxPairCount maxValCount(MaxPairCount m1, MaxPairCount m2) {
        if (m1.getVal() < m2.getVal()) {
            return m2;
        }
        if (m1.getVal() > m2.getVal()) {
            return m1;
        }
        return new MaxPairCount(m1.getVal(), (m1.getCount() + m2.getCount()));
    }

}

class MaxPairCount {

    private int count;
    private int val;

    public MaxPairCount(int val, int count) {
        this.count = count;
        this.val = val;
    }

    public int getCount() {
        return this.count;
    }

    public int getVal() {
        return this.val;
    }
}
