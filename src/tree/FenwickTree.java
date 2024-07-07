package tree;

public class FenwickTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] sumArr = buildFenwickTree(arr);
        for(int x :sumArr){
            System.out.print(x+",");
        }
    }

    private static int[] buildFenwickTree(int[] arr) {
        if (arr.length <= 0) {
            return new int[]{};           
        }

        int idx = 0;
        int[] sumArr = new int[arr.length];
        while (idx <arr.length) {
            updateIndex(sumArr, idx, arr[idx],arr.length);
            idx++;
        }
        return sumArr;
    }

    private static void updateIndex(int[] sumArr, int idx, int val,int n) {
      
        int x = idx+1;
        while (x <= n) {
            //System.out.println(x);
            sumArr[x] += val;
            x += (x & -x);
        }
    }
}
