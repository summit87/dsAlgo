package tree;

public class FenwickTree {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int[] sumArr = buildFenwickTree(arr);
        int c = 4;
        arr[c] = 10;
        updateIndex(sumArr, 4, arr[4], arr.length);
        for(int x : sumArr){
            System.out.print(x+",");
        }
        //System.out.println(sum(6,sumArr));
    }

    private static int[] buildFenwickTree(int[] arr) {
        if (arr.length <= 0) {
            return new int[]{};           
        }

        int idx = 0;
        int[] sumArr = new int[arr.length+1];
        while (idx <arr.length) {
            updateIndex(sumArr, idx, arr[idx],arr.length);
            idx++;
        }
        return sumArr;
    }

    private static void updateIndex(int[] sumArr, int idx, int val,int n) {
      
        int x = idx+1;
        while (x <= n) {
           // System.out.println(x);
            sumArr[x] += val;
            x += (x & -x);
        }
    }

    private static int sum(int r,int[] sumArr){
        int sum = 0;
        while(r > 0){
            sum+=sumArr[r];
            r = r - (r&-r);
        }
        return sum;
    }
}
