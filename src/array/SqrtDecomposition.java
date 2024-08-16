package array;
/**
 * https://www.geeksforgeeks.org/square-root-sqrt-decomposition-algorithm/
 */
public class SqrtDecomposition {
    public static void main(String[] args) {
        int[] a = {1, 5, 2, 4, 6, 1, 3, 5, 7};
        int[] block = sumArray(a);
        System.out.println(getSum(0, 1, block, a));
    }

    private static int[] sumArray(int[] a){
        int n = (int)Math.sqrt(a.length);
        int[] block = new int[n];
        int j=0;
        for(int i=0;i<n;i++){
            int sum = 0;
            int k = 0;
            while(j < a.length && k < n){
                sum+=a[j];
                k++;
                j++;
            }
            block[i] = sum;
        }
        return block;
    }

    private static int getSum(int l,int r,int[] sum,int[] a){
        int result = 0;
        while(l < r && l % sum.length != 0 ){
            System.out.println("Handling left case");
            result+=a[l];
            l++;
        }
        int i=0;
        while( l+sum.length-1 <= r){
            System.out.println("Handling complete blocking case case");
            result+=sum[l % sum.length];
            l+=sum.length;
            i++;
        }

        while(l <= r){
            System.out.println("Handnling right case");
            result+=a[l];
            l++;
        }
        return result;
    } 

    private static void update(int l,int val,int[] sum,int[] a){
        int oldVal = a[l];
        sum[l%sum.length] +=val-oldVal;
        a[l] = val;
    }
}
