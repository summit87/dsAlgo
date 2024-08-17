package array;

public class RangeMinimumQuery {

    public static void main(String[] args) {
        int[] a = {4,6,1,5,7,3};
        int[][] lookup = lookupTable(a);
        System.out.println(getMin(1, 5, lookup, a));

    }

    private static int[][] lookupTable(int[] a) {
        int[][] lookup = new int[a.length][(int) Math.sqrt(a.length) + 1];
        for (int i = 0; i < a.length; i++) {
            lookup[i][0] = i;
        }
        int len = (int) Math.sqrt(a.length) + 1;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j + Math.pow(2, i) - 1 < a.length; j++) {
                if(a[lookup[j][i-1]] < a[lookup[j+(int)Math.pow(2, i-1)][i-1]]){
                    lookup[j][i] = lookup[j][i-1];
                }else{
                    lookup[j][i] = lookup[j+(int)Math.pow(2, i-1)][i-1];
                }
            }
        }
        return lookup;
    }

    private static int getMin(int l,int r,int[][] lookup,int[] a){
        int k = (int) Math.log(r-l+1);
        return Math.min(a[lookup[l][k]], a[lookup[r-(int)Math.pow(2, k-1)][k]]);
    }

    
}
