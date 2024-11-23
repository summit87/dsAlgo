package dp;

public class LIS {

    static int max_res = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] a = {10,9,2,5,3,7,101,18};
        lis(a, a.length);
        System.out.println(max_res);
        System.out.println(lisInDP(a,a.length));
    }

    private static int lis(int[] a, int length) {
       
        int res = 1;
        int max_end = 1;
        for (int i = 1; i < length; i++) {
            res = lis(a, i);
            if (1 + res > max_end && a[i - 1] < a[length - 1]) {
                max_end = res + 1;
            }
        }
        if (max_res < max_end) {
            max_res = max_end;
        }
        return max_end;
    }

    private static int lisInDP(int[] a,int length){
        int[] lis = new int[length];
        for(int i=0;i<length;i++){
            lis[i] = 1;
        }
        for(int i=1;i<length;i++){
            for(int j=0;j<i;j++){
                if(a[i] > a[j] && 1+lis[j] > lis[i]){
                    lis[i] = 1+lis[j];
                }
            }
        }
        return lis[length-1];
    }
}
