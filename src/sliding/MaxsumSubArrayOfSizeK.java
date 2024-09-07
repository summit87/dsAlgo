package array.slidingWindow;

public class MaxsumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] a  = {1, 4, 2, 10, 23, 3, 1, 0, 20};
        int k = 4;
        System.out.println(maxSum(a, k));
    }

    private static int maxSum(int[] a,int k){
        int maxSum = Integer.MIN_VALUE;
        int p=0;
        int q = k-1;
        int sum = 0;
        int t = 0;
        int st = 0;
        int end = k-1;
        while(q < a.length){
            sum+=a[p];
            p++;
            if(p == q && p < a.length){
                sum+=a[p];
                if(maxSum < sum){
                    maxSum = sum;
                    end = q;
                    st = t;
                }
                t = t+1;
                p = t;
                q++;
                sum = 0;
            }
        }
        System.out.println("start > "+st+" , end > "+end);
        return maxSum;
    }

    
}
