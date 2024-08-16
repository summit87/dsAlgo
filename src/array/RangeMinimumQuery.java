package array;

public class RangeMinimumQuery {

    public static void main(String[] args) {
        int[] a = {4,6,1,5,7,3};
        int[][] lookup = lookupTable(a);
        for(int i=0;i<lookup.length;i++){
            for(int j=0;j<lookup[i].length;j++){
                System.out.print(lookup[i][j]+",");
            }
            System.out.println();
        }

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
}
